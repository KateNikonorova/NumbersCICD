package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;
import java.io.FileNotFoundException;

class AppTest {

    private static NumberCalc app1;
    private static NumberCalc app2;
    private static NumberCalc app3;
//    private static NumberCalc app4;

    @BeforeAll
    static void setUpAll() {
        app1 = new NumberCalc();
        app2 = new NumberCalc();
        app3 = new NumberCalc();

        try {
            app1.readFile(getFile("test1.txt"));
            app2.readFile(getFile("test2.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static File getFile(String filename) {
        ClassLoader classLoader = AppTest.class.getClassLoader();
        File file = new File(classLoader.getResource(filename).getFile());
        return file;
    }


    @BeforeEach
    void setUp() {
    }

    /*
    @org.junit.jupiter.api.Test
    void readFile() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("test1.txt").getFile());

        try {
            App.readFile(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Assertions.assertNull(file);
    }

     */

    @org.junit.jupiter.api.Test
    void _min() {
        Assertions.assertEquals(1, app1._min());
        Assertions.assertEquals(1, app2._min());
    }

    @org.junit.jupiter.api.Test
    void _max() {
        Assertions.assertEquals(1, app1._max());
        Assertions.assertEquals(4, app2._max());
    }

    @org.junit.jupiter.api.Test
    void _sum() {
        Assertions.assertEquals(1, app1._sum());
        Assertions.assertEquals(10, app2._sum());
    }

    @org.junit.jupiter.api.Test
    void _mult() {
        Assertions.assertEquals(1, app1._mult());
        Assertions.assertEquals(24, app2._mult());
    }
}