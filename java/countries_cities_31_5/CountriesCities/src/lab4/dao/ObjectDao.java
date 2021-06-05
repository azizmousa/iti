package lab4.dao;
import java.util.List;

public interface ObjectDao {

    List<?> loadObjectsFromCSV(String path, boolean hasHeader);
}
