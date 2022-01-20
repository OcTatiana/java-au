import java.io.IOException;

public class Program {
    public static void main (String[] args) throws IOException {
        String userSource = "C:\\Users\\admin\\IdeaProjects\\java-au\\Generator\\src\\solution.txt";
        String source = "C:\\Users\\admin\\IdeaProjects\\java-au\\Generator\\src\\math.md";
        String userSolutionContent = IOUtils.readData(userSource);
        String oldFileContent = IOUtils.readData(source);
        String newFileContent = Generator.getNewContent(userSolutionContent, oldFileContent, source);
        if (newFileContent != null) {
            IOUtils.writeData(source, newFileContent);
        }
    }
}
