import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class IOUtils {
    public static String readData(String fileName) throws IOException {

        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    public static void writeData(String fileName, String data) throws IOException {
        File file = new File(fileName);
        FileWriter writer = new FileWriter(file);
        writer.write(data);
        writer.flush();
        writer.close();
    }
}
