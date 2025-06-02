package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class SpotifyCsvUtils {

    public static boolean validateCsvFormat(String filePath) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            if (lines.isEmpty()) return false;

            String header = lines.get(0);
            return header.contains("track_id") && header.contains("track_name")
                    && header.contains("track_artist");
        } catch (IOException e) {
            return false;
        }
    }

    public static int countDataRows(String filePath) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        return Math.max(0, lines.size() - 1); // -1 para excluir header
    }
}
