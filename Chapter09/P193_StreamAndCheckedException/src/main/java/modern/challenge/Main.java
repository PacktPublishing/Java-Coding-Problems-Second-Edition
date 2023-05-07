package modern.challenge;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.List;

public class Main {    

    static void readFile(Path path) throws IOException {

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(path.toFile())))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    static void readFiles(List<Path> paths) throws IOException {

        paths.forEach(p -> {
            try {
                readFile(p);
            } catch (IOException e) {
                // throw new RuntimeException(e);
                // Exceptions.throwChecked(e);
                Exceptions.throwChecked(new IOException("Some files are corrupted", e));
            }
        });
    }

    public static void main(String[] args) {

        List<Path> paths = List.of(
                Path.of("/learning/packt/JavaModernChallengeFE.pdf"),
                Path.of("/learning/packt/JavaModernChallengeSE.pdf"),
                Path.of("/learning/packt/jOOQmasterclass.pdf")
        );

        try {
            readFiles(paths);
        } catch (IOException e) {
            System.out.println(e + " \n " + e.getCause());
        }
    }
}