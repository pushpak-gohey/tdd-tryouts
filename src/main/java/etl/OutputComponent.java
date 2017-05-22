package etl;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by pushpak on 13/5/17.
 */
public class OutputComponent {
    private final String path;

    public OutputComponent(String outputPath) {
        this.path = outputPath;
    }

    public void write(List<Record<String>> records) throws IOException {

        if (!Paths.get(path).toFile().exists()) {
            Files.createDirectory(Paths.get(path));
        }

        records.stream()
                .collect(Collectors
                        .groupingBy(Record::getFileName, Collectors.mapping(Record::getValue, Collectors.toList())))
                .forEach((fileName, listOfFileContnents) -> {
                    try {
                        BufferedWriter writer = Files.newBufferedWriter(Paths.get(path + "/" + fileName));
                        listOfFileContnents.stream().forEach(str -> {
                            try {
                                writer.write(str);
                                writer.newLine();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
                        writer.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
    }
}
