package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class NumberCalc {

    private ArrayList<Integer> numbers;

    public void readFile(String fileName) {
        try {
            readFile(new File(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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


    public Optional<Integer> _min() {
        if (isEmpty()) return Optional.empty();

        int min = (int)numbers.get(0);

        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) < min) {
                min = numbers.get(i);
            }
        }

        return Optional.of(min);
    }

    public Optional<Integer> _max() {
        if (isEmpty()) return Optional.empty();

        int max = (int)numbers.get(0);

        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) > max) {
                max = numbers.get(i);
            }
        }

        return Optional.of(max);
    }

    public Optional<Long> _sum() {

        if (isEmpty()) return Optional.empty();

        long sum = 0;

        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }

        return Optional.of(sum);
    }

    public Optional<Long> _mult() {

        if (isEmpty()) return Optional.empty();

        long mult = 1;

        for (int i = 0; i < numbers.size(); i++) {
            mult *= numbers.get(i);
        }

        return Optional.of(mult);
    }
}
