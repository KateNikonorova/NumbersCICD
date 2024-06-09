package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final String FILENAME = "input.txt";
    private static ArrayList<Integer> numbers;

    public static void main( String[] args ) {
        try {
            readFile(FILENAME);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        if ((numbers == null) || numbers.isEmpty()) return;

        System.out.println("Минимальное число: "       + _min());
        System.out.println("Максимальное число: "      + _max());
        System.out.println("Сумма всех чисел: "        + _sum());
        System.out.println("Произведение всех чисел: " + _mult());
    }

    private static void readFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        numbers = new ArrayList((int)file.length() / 2);

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                numbers.add(scanner.nextInt());
            } else {
                scanner.next();
            }
        }
    }

    private static int _min() {
        int min = (int)numbers.get(0);

        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) < min) {
                min = numbers.get(i);
            }
        }

        return min;
    }

    private static int _max() {
        int max = (int)numbers.get(0);

        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) > max) {
                max = numbers.get(i);
            }
        }

        return max;
    }

    private static long _sum() {
        long sum = 0;

        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }

        return sum;
    }

    private static long _mult() {
        long mult = 1;

        for (int i = 0; i < numbers.size(); i++) {
            mult *= numbers.get(i);
        }

        return mult;
    }
}
