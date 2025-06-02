import model.TestFile;

import java.io.IOException;

public class MainTestFile {


    public static void main(String[] args) {
        TestFile testFile = new TestFile();
        try {
            testFile.readCsvData();
            testFile.generateSqlFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
