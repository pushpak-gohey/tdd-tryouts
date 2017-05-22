package etl;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * Created by pushpak on 13/5/17.
 */
public class InputComponentTest {
    @Test
    public void itShouldReadFilesFromGivenDirectoryPath() {
        //given
        String path = "/home/pushpak/Downloads/inputs";
        List<Record<String>> records = null;

        //when
        InputComponent inputComponent = new InputComponent(path);
        try {
            records = inputComponent.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //then
        Record[] expected = {
                new Record<>("This is file 1", "input1.txt"),
                new Record<>("It is of no use", "input1.txt"),
                new Record<>("Delete it.", "input1.txt"),
                new Record<>("Bye.", "input1.txt"),
                new Record<>("This is file 2", "input2.txt"),
                new Record<>("It is also of no use", "input2.txt"),
                new Record<>("Delete it.", "input2.txt"),
                new Record<>("Bye.", "input2.txt"),
                new Record<>("This is file 3.", "input3.txt"),
                new Record<>("It is of no use.", "input3.txt"),
                new Record<>("Delete it.", "input3.txt"),
                new Record<>("Bye.", "input3.txt")};

        Assert.assertArrayEquals(expected, records.toArray());


    }

    @Test
    public void itShouldReadFilesFromGivenFilePath() {
        //given
        String path = "/home/pushpak/Downloads/inputs/input1.txt";
        List<Record<String>> records = null;

        //when
        InputComponent inputComponent = new InputComponent(path);
        try {
            records = inputComponent.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //then
        Record[] expected = {
                new Record<>("This is file 1", "input1.txt"),
                new Record<>("It is of no use", "input1.txt"),
                new Record<>("Delete it.", "input1.txt"),
                new Record<>("Bye.", "input1.txt")};

        Assert.assertArrayEquals(expected, records.toArray());


    }
}
