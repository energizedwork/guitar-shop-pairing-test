package uw;

import java.io.File;
import java.nio.file.Files;

public class TestHelper {

    public static String read(String name) {
        try {

            final StringBuilder sb = new StringBuilder();
            File csvFile = new File(name);
            Files.readAllLines(csvFile.toPath()).stream().forEach(line -> sb.append(line + '\n'));

            return sb.toString();

        } catch (Exception e) {
            throw new RuntimeException("could not read " + name, e);
        }
    }

}
