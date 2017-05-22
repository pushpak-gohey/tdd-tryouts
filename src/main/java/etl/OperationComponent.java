package etl;

import java.util.List;

/**
 * Created by pushpak on 15/5/17.
 */
public interface OperationComponent {
    List<Record<String>> transform(List<Record<String>> inputRecords);
}
