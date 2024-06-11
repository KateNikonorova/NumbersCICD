package org.example;

public class App
{
    public static void main( String[] args ) {

        String fileName = "input.txt";
        NumberCalc calc = new NumberCalc();

        calc.readFile(fileName);

        if (calc.isEmpty()) return;

        System.out.println("Минимальное число: "       + calc._min().get());
        System.out.println("Максимальное число: "      + calc._max().get());
        System.out.println("Сумма всех чисел: "        + calc._sum().get());
        System.out.println("Произведение всех чисел: " + calc._mult().get());
    }


}
