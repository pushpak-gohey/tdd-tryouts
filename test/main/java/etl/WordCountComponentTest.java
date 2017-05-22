package etl;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by pushpak on 13/5/17.
 */
public class WordCountComponentTest {

    @Test
    public void itShouldCountUniqueWords() {
        //given
        List<Record<String>> inputRecords = Arrays.asList(
                new Record<>("This is file 1", "input1.txt"),
                new Record<>("It is of no use", "input1.txt"),
                new Record<>("it IS OF no use", "input1.txt"),
                new Record<>("Delete it.", "input1.txt"),
                new Record<>("Delete it.", "input2.txt"),
                new Record<>("Bye.", "input1.txt")
        );

        //when
        WordCountComponent wordCountComponent = new WordCountComponent();
        List<Record<String>> transformedRecordList = wordCountComponent.transform(inputRecords);

        //then

        Record[] expected = new Record[]{new Record<>("use->2", "input1.txt"),
                new Record<>("Delete->1", "input2.txt"),
                new Record<>("1->1", "input1.txt"),
                new Record<>("no->2", "input1.txt"),
                new Record<>("is->3", "input1.txt"),
                new Record<>("It->2", "input1.txt"),
                new Record<>("This->1", "input1.txt"),
                new Record<>("of->2", "input1.txt"),
                new Record<>("it.->1", "input1.txt"),
                new Record<>("file->1", "input1.txt"),
                new Record<>("it.->1", "input2.txt"),
                new Record<>("Delete->1", "input1.txt"),
                new Record<>("Bye.->1", "input1.txt")};


        Assert.assertArrayEquals(expected, transformedRecordList.toArray());

    }
}
