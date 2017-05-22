package etl;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by pushpak on 13/5/17.
 */
public class EtlExecutorTest {
    @Test
    public void itShouldConnectComponentsForCapitalizeEtl() throws IOException {
        //given
        String inputPath = "/home/pushpak/Downloads/inputs";
        String outputPath = "/home/pushpak/Downloads/outputs/capitalize";

        InputComponent inputComponent = new InputComponent(inputPath);
        CapitalizeComponent capitalizeComponent = new CapitalizeComponent();
        OutputComponent outputComponent = new OutputComponent(outputPath);

        //when
        EtlExecutor etlExecutor = new EtlExecutor(inputComponent, capitalizeComponent, outputComponent);

        etlExecutor.execute();

        //then
        InputComponent inputComponent1 = new InputComponent(outputPath);
        List<Record<String>> actual = inputComponent1.read();
        Record[] expected = new Record[]{
                new Record<>("THIS IS FILE 1", "input1.txt"),
                new Record<>("IT IS OF NO USE", "input1.txt"),
                new Record<>("DELETE IT.", "input1.txt"),
                new Record<>("BYE.", "input1.txt"),
                new Record<>("THIS IS FILE 2", "input2.txt"),
                new Record<>("IT IS ALSO OF NO USE", "input2.txt"),
                new Record<>("DELETE IT.", "input2.txt"),
                new Record<>("BYE.", "input2.txt"),
                new Record<>("THIS IS FILE 3.", "input3.txt"),
                new Record<>("IT IS OF NO USE.", "input3.txt"),
                new Record<>("DELETE IT.", "input3.txt"),
                new Record<>("BYE.", "input3.txt")};

        Assert.assertArrayEquals(expected, actual.toArray());

    }

    @Test
    public void itShouldConnectComponentsForWordCountEtl() throws IOException {
        //given
        String inputPath = "/home/pushpak/Downloads/inputs";
        String outputPath = "/home/pushpak/Downloads/outputs/wordcount";

        InputComponent inputComponent = new InputComponent(inputPath);
        WordCountComponent wordCountComponent = new WordCountComponent();
        OutputComponent outputComponent = new OutputComponent(outputPath);

        //when
        EtlExecutor etlExecutor = new EtlExecutor(inputComponent, wordCountComponent, outputComponent);

        etlExecutor.execute();

        //then
        InputComponent inputComponent1 = new InputComponent(outputPath);
        List<Record<String>> actual = inputComponent1.read();

        Record[] expected = new Record[]{new Record<>( "use->1", "input1.txt"),
        new Record<>( "is->2", "input1.txt"),
        new Record<>( "of->1", "input1.txt"),
        new Record<>( "Bye.->1", "input1.txt"),
        new Record<>( "file->1", "input1.txt"),
        new Record<>( "1->1", "input1.txt"),
        new Record<>( "It->1", "input1.txt"),
        new Record<>( "Delete->1", "input1.txt"),
        new Record<>( "no->1", "input1.txt"),
        new Record<>( "This->1", "input1.txt"),
        new Record<>( "it.->1", "input1.txt"),
        new Record<>( "no->1", "input2.txt"),
        new Record<>( "also->1", "input2.txt"),
        new Record<>( "This->1", "input2.txt"),
        new Record<>( "is->2", "input2.txt"),
        new Record<>( "it.->1", "input2.txt"),
        new Record<>( "use->1", "input2.txt"),
        new Record<>( "It->1", "input2.txt"),
        new Record<>( "Bye.->1", "input2.txt"),
        new Record<>( "Delete->1", "input2.txt"),
        new Record<>( "file->1", "input2.txt"),
        new Record<>( "2->1", "input2.txt"),
        new Record<>( "of->1", "input2.txt"),
        new Record<>( "use.->1", "input3.txt"),
        new Record<>( "it.->1", "input3.txt"),
        new Record<>( "This->1", "input3.txt"),
        new Record<>( "is->2", "input3.txt"),
        new Record<>( "no->1", "input3.txt"),
        new Record<>( "of->1", "input3.txt"),
        new Record<>( "3.->1", "input3.txt"),
        new Record<>( "Bye.->1", "input3.txt"),
        new Record<>( "Delete->1", "input3.txt"),
        new Record<>( "It->1", "input3.txt"),
        new Record<>( "file->1", "input3.txt")};


        Assert.assertArrayEquals(expected, actual.toArray());

    }
}
