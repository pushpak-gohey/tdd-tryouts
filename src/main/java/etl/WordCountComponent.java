package etl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by pushpak on 14/5/17.
 */
public class WordCountComponent implements OperationComponent {

    @Override
    public List<Record<String>> transform(List<Record<String>> inputRecords) {

        Stream<Record<String>> wordRecords = getRecordStream(inputRecords);

        Map<Record<String>, List<Record<String>>> wordGroup = getRecordListMap(wordRecords);

        List<Record<String>> transformedRecordList = getWordCountRecordsList(wordGroup);

        return transformedRecordList;
    }

    private List<Record<String>> getWordCountRecordsList(Map<Record<String>, List<Record<String>>> wordGroup) {
        return wordGroup.entrySet().stream().map(recordListEntry ->
                    new Record<>(recordListEntry.getKey().getValue() + "->" + recordListEntry.getValue().size()
                            , recordListEntry.getKey().getFileName())).collect(Collectors.toList());
    }

    private Map<Record<String>, List<Record<String>>> getRecordListMap(Stream<Record<String>> wordRecords) {
        return wordRecords.collect(Collectors
                .groupingBy(o -> getRecord(o)));
    }

    private Record<String> getRecord(Record<String> o) {
        return new Record<String>(o.getValue(), o.getFileName()) {

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                Record<String> record = (Record<String>) o;

                if (this.getValue() != null ?
                        !this.getValue().equalsIgnoreCase(record.getValue())
                        : record.getValue() != null) {
                    return false;
                }

                return this.getFileName() != null ? this.getFileName().equals(record.getFileName()) : record.getFileName() == null;
            }

            @Override
            public int hashCode() {
                int result = this.getValue() != null ? this.getValue().toUpperCase().hashCode() : 0;
                result = 31 * result + (this.getFileName() != null ? this.getFileName().toUpperCase().hashCode() : 0);
                return result;
            }
        };
    }

    private Stream<Record<String>> getRecordStream(List<Record<String>> inputRecords) {
        return inputRecords.stream()
                    .flatMap(record -> Arrays.stream(record.getValue().split(" "))
                            .map(token -> new Record<>(token, record.getFileName())));
    }

}
