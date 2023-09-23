package modern.challenge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {

    public static void main(String[] args) throws IOException {

        Path chineseUtf16File = Paths.get("chineseUTF16.txt");
        Path chineseUtf8File = Paths.get("chineseUTF8.txt");

        System.out.println("\n\nRead a text file using UTF-8 (before JDK 18):");
        System.out.println("-------------------------------------------------");
        try ( BufferedReader br = new BufferedReader(
                new FileReader(chineseUtf8File.toFile(), StandardCharsets.UTF_8))) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }

        System.out.println("\n\nRead a text file using UTF-8 (JDK 18+):");
        System.out.println("-------------------------------------------");
        try ( BufferedReader br = new BufferedReader(
                new FileReader(chineseUtf8File.toFile()))) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }

        System.out.println("\n\nRead a text file using UTF-16 (all JDKs):");
        System.out.println("---------------------------------------------");
        try ( BufferedReader br = new BufferedReader(
                new FileReader(chineseUtf16File.toFile(), StandardCharsets.UTF_16))) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }

        System.out.println("\n\nWrite text file using UTF-8 (before JDK 18)");
        System.out.println("-----------------------------------------------");

        Path textFile1 = Paths.get("sampleUtf8BeforeJDK18.txt");
        try ( BufferedWriter bw = Files.newBufferedWriter(
                textFile1, StandardCharsets.UTF_8,
                StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {

            bw.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit, ");
            bw.newLine();
            bw.write("sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        }

        System.out.println("\n\nWrite text file using UTF-8 (JDK 18+)");
        System.out.println("-----------------------------------------");

        Path textFile2 = Paths.get("sampleUtf8AfterJDK18.txt");
        try ( BufferedWriter bw = Files.newBufferedWriter(textFile2,
                StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {

            bw.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit, ");
            bw.newLine();
            bw.write("sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        }

        System.out.println("\n\nWrite text file using UTF-16 (all JDKs)");
        System.out.println("-------------------------------------------");

        Path textFile3 = Paths.get("sampleUtf16.txt");
        try ( BufferedWriter bw = Files.newBufferedWriter(
                textFile3, StandardCharsets.UTF_16,
                StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {

            bw.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit, ");
            bw.newLine();
            bw.write("sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        }
    }
}
