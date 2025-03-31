import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("emails.txt");
        Stream<String> lines = Files.lines(path);
        ;
        lines
                .filter(x -> !x.startsWith("Spam"))
                .forEach(System.out::println);
    }
}
