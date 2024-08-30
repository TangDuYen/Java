package DataLayer;

import java.io.IOException;
import java.util.List;

public interface IFileManager<T> {
    List<T> readDataFromFile() throws IOException;
}
