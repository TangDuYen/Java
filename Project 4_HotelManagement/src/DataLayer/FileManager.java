package DataLayer;


import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

public class FileManager implements IFileManager<String> {

    private String fileName;

    public FileManager() {
    }

    public FileManager(String inputDataFile) {
        this.fileName = inputDataFile;
    }

    @Override
    public List<String> readDataFromFile() throws IOException {
        List<String> result;
        result = Files.readAllLines(new File(fileName).toPath(), Charset.forName("utf-8"));
        return result;
    }
}
