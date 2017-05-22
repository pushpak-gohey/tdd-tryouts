package etl;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by pushpak on 13/5/17.
 */
public class CapitalizeComponentTest {
    @Test
    public void itShouldCapitalizeTheString() {
        //given
        List<Record<String>> recordsToCapitalize = Arrays.asList(
                new Record<>("This is file 1", "input1.txt"),
                new Record<>("It is of no use", "input1.txt"),
                new Record<>("Delete it.", "input1.txt"),
                new Record<>("Bye.", "input1.txt"));


        //when
        CapitalizeComponent p1 = new CapitalizeComponent();
        List<Record<String>> capitalizedRecords = p1.transform(recordsToCapitalize);

        //then
        Record[] expected = {
                new Record<>("THIS IS FILE 1", "input1.txt"),
                new Record<>("IT IS OF NO USE", "input1.txt"),
                new Record<>("DELETE IT.", "input1.txt"),
                new Record<>("BYE.", "input1.txt")};

        Assert.assertArrayEquals(expected, capitalizedRecords.toArray());
    }
}
