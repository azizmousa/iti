package pyramids.dao;

import pyramids.model.Pyramid;

import java.util.List;

public interface ObjectDao {

    List<Pyramid> loadPyramidFromCSV(String path, boolean hasHeader);
}
