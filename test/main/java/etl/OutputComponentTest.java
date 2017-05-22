package etl;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by pushpak on 13/5/17.
 */
public class OutputComponentTest {
    @Test
    public void itShouldWriteFilesInDirectory() throws IOException {
        //given
        List<Record<String>> recordsToCapitalize = new ArrayList<Record<String>>(Arrays.asList(
                new Record<>("This is file 1", "input1.txt"),
                new Record<>("It is of no use", "input1.txt"),
                new Record<>("Delete it.", "input1.txt"),
                new Record<>("Bye.", "input1.txt")));

        String outputPath = "/home/pushpak/Downloads/outputs/output-test";

        //when
        OutputComponent output = new OutputComponent(outputPath);
        output.write(recordsToCapitalize);

        //then
        InputComponent inputComponent = new InputComponent(outputPath);
        List<Record<String>> actual = inputComponent.read();
        List<Record<String>> expected = Arrays.asList(
                new Record<>("This is file 1", "input1.txt"),
                new Record<>("It is of no use", "input1.txt"),
                new Record<>("Delete it.", "input1.txt"),
                new Record<>("Bye.", "input1.txt"));

        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

}
