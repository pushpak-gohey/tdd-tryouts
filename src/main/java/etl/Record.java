package etl;

/**
 * Created by pushpak on 13/5/17.
 */
public class Record<V> {
    private final V value ;
    private final String fileName ;

    public Record(V value, String fileName) {
        this.value = value;
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "Record( Value: '" + value + "' fileName: " + fileName + ")";
    }

    public V getValue() {
        return value;
    }

    public String getFileName() {
        return fileName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Record<?> record = (Record<?>) o;

        if (value != null ? !value.equals(record.value) : record.value != null) return false;
        return fileName != null ? fileName.equals(record.fileName) : record.fileName == null;
    }

    @Override
    public int hashCode() {
        int result = value != null ? value.hashCode() : 0;
        result = 31 * result + (fileName != null ? fileName.hashCode() : 0);
        return result;
    }
}
