package org.example;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class AppTestBenchmarks {

    private static String fileName = "test/speedCheck1.txt";

//    @Benchmark
//    @BenchmarkMode(Mode.AverageTime)
//    public void benchmarkMin() {
//        NumberCalc calc = new NumberCalc();
//        calc.readFile(fileName);
//        calc._min();
//    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public void benchmarkMax() {
        NumberCalc calc = new NumberCalc();
        calc.readFile(fileName);
        calc._max();
    }

//    @Benchmark
//    @BenchmarkMode(Mode.AverageTime)
//    public void benchmarkSum() {
//        NumberCalc calc = new NumberCalc();
//        calc.readFile(fileName);
//        calc._sum();
//    }
//
//    @Benchmark
//    @BenchmarkMode(Mode.AverageTime)
//    public void benchmarkMult() {
//        NumberCalc calc = new NumberCalc();
//        calc.readFile(fileName);
//        calc._mult();
//    }

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(AppTestBenchmarks.class.getSimpleName())
                .forks(1)
                .warmupBatchSize(1)
                .measurementIterations(1)
                .build();
        new Runner(options).run();
    }
}
