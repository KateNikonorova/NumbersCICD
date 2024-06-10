package org.example;

import java.io.FileNotFoundException;

public class App
{
    public static void main( String[] args ) {

        String fileName = "input.txt";
        NumberCalc calc = new NumberCalc();

        try {
            calc.readFile(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        if (calc.isEmpty()) return;

        System.out.println("Минимальное число: "       + calc._min());
        System.out.println("Максимальное число: "      + calc._max());
        System.out.println("Сумма всех чисел: "        + calc._sum());
        System.out.println("Произведение всех чисел: " + calc._mult());
    }


}
