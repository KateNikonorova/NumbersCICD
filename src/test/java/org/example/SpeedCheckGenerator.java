package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class SpeedCheckGenerator {

    private static Random random = new Random();
    private static int getRandomNumberUsingInts(int min, int max) {
        return random.ints(min, max)
                .findFirst()
                .getAsInt();
    }

    public static void main(String[] args) throws IOException {
        Files.createDirectories(Paths.get("test"));
        for (int i = 1; i < 11; i++) {
            generate(i * 100_000, "test/speedCheck" + String.valueOf(i) + ".txt");
        }
    }


    public static void generate(int size, String filename) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < size; i++) {
            sb.append(getRandomNumberUsingInts(1, 100));
            sb.append(" ");
        }

        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(filename), "utf-8"))) {
            writer.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
