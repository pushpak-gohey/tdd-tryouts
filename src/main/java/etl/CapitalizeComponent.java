package etl;

import java.util.List;
import java.util.stream.Collectors;

public class CapitalizeComponent implements OperationComponent{

    @Override
    public List<Record<String>> transform(List<Record<String>> stringToCapitalize) {
        return stringToCapitalize.stream().map(record ->
                new Record<>(record.getValue().toUpperCase(), record.getFileName())).collect(Collectors.toList());
    }
}
