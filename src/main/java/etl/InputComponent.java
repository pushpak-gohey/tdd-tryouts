package etl;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by pushpak on 13/5/17.
 */
public class InputComponent {

    private String path = null;

    public InputComponent(String path) {
        this.path = path;
    }

    public List<Record<String>> read() throws IOException {
        List<Record<String>> records = new ArrayList<>();
        Path filePath = Paths.get(path);
        if (Files.isDirectory(filePath)) {
            Files.newDirectoryStream(filePath)
                    .forEach(file -> {
                        try {
                            records.addAll(getFileContnents(file));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });

        } else {
            records.addAll(getFileContnents(filePath));
        }

        return records;
    }

    private List<Record<String>> getFileContnents(Path filePath) throws IOException {
        return Files.lines(filePath).map(line -> new Record<>(line, filePath.getFileName().toString())).collect(Collectors.toList());
    }
}
