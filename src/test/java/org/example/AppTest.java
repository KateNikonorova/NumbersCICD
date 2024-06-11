package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

class AppTest {

    private static NumberCalc app1;
    private static NumberCalc app2;
    private static NumberCalc app3;
    private static NumberCalc app4;
    private static NumberCalc app5;

    @BeforeAll
    static void setUpAll() {
        app1 = new NumberCalc();
        app2 = new NumberCalc();
        app3 = new NumberCalc();
        app4 = new NumberCalc();
        app5 = new NumberCalc();

        try {
            app1.readFile(getFile("test1.txt"));
            app2.readFile(getFile("test2.txt"));
            app3.readFile(getFile("test3.txt"));
            app4.readFile(getFile("test4.txt"));
            app5.readFile(getFile("test5.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static File getFile(String filename) {
        ClassLoader classLoader = AppTest.class.getClassLoader();
        File file = new File(classLoader.getResource(filename).getFile());
        return file;
    }

    @Test
    void readFileTest() {
        NumberCalc app = new NumberCalc();

        try {
            app.readFile(getFile("test1.txt"));
            Assertions.assertFalse(app.isEmpty());
            Assertions.assertEquals(1, app.numbersCount());

            app.readFile(getFile("test2.txt"));
            Assertions.assertFalse(app.isEmpty());
            Assertions.assertEquals(4, app.numbersCount());

            app.readFile(getFile("test3.txt"));
            Assertions.assertTrue(app.isEmpty());
            Assertions.assertEquals(0, app.numbersCount());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Test
    void _min() {
        Assertions.assertEquals(1, app1._min().get());
        Assertions.assertEquals(1, app2._min().get());
        Assertions.assertFalse(app3._min().isPresent());
        Assertions.assertEquals(-43, app4._min().get());
        Assertions.assertEquals(-34, app5._min().get());
    }

    @Test
    void _max() {
        Assertions.assertEquals(1, app1._max().get());
        Assertions.assertEquals(4, app2._max().get());
        Assertions.assertFalse(app3._max().isPresent());
        Assertions.assertEquals(44, app4._max().get());
        Assertions.assertEquals(36, app5._max().get());
    }

    @Test
    void _sum() {
        Assertions.assertEquals(1, app1._sum().get());
        Assertions.assertEquals(10, app2._sum().get());
        Assertions.assertFalse(app3._sum().isPresent());
        Assertions.assertEquals(9, app4._sum().get());
        Assertions.assertEquals(10, app5._sum().get());
    }

    @Test
    void _mult() {
        Assertions.assertEquals(1, app1._mult().get());
        Assertions.assertEquals(24, app2._mult().get());
        Assertions.assertFalse(app3._mult().isPresent());
        Assertions.assertEquals(0, app4._mult().get());
        Assertions.assertEquals(-10_575_360, app5._mult().get());
    }
}