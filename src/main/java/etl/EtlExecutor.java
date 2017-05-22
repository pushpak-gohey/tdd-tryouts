package etl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by pushpak on 13/5/17.
 */
public class EtlExecutor {

    private InputComponent inputComponent = null;
    private OperationComponent operationComponent = null;
    private OutputComponent outputComponent = null;

    public EtlExecutor(InputComponent inputComponent, OperationComponent operationComponent, OutputComponent outputComponent) {
        this.inputComponent = inputComponent;
        this.operationComponent = operationComponent;
        this.outputComponent = outputComponent;
    }

    public void execute() throws IOException {
        List<Record<String>> inputFileContents = inputComponent.read();

        List<Record<String>>  transformedFileContents = operationComponent.transform(inputFileContents);

        outputComponent.write(transformedFileContents);
    }
}
