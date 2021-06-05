package lab1.dao;

import java.util.List;

public interface ObjectDAO {
    List<?> readCSVFile(String path, boolean hasHeader);
}
