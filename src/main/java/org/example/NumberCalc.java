package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class NumberCalc {

    private ArrayList<Integer> numbers;

    public void readFile(String fileName) throws FileNotFoundException {
        readFile(new File(fileName));
    }

    public void readFile(File file) throws FileNotFoundException {
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

    public int numbersCount() {
        return numbers.size();
    }

    public boolean isEmpty() {
        return (numbers == null) || numbers.isEmpty();
    }


    public int _min() {
        int min = (int)numbers.get(0);

        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) < min) {
                min = numbers.get(i);
            }
        }

        return min;
    }

    public int _max() {
        int max = (int)numbers.get(0);

        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) > max) {
                max = numbers.get(i);
            }
        }

        return max;
    }

    public long _sum() {
        long sum = 0;

        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }

        return sum;
    }

    public long _mult() {
        long mult = 1;

        for (int i = 0; i < numbers.size(); i++) {
            mult *= numbers.get(i);
        }

        return mult;
    }
}
