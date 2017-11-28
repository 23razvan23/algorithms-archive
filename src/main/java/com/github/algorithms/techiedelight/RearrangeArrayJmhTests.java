package com.github.algorithms.techiedelight;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@OutputTimeUnit(TimeUnit.MILLISECONDS)
@BenchmarkMode({Mode.Throughput, Mode.SingleShotTime})
@State(Scope.Thread)
@Threads(1)
public class RearrangeArrayJmhTests {
    private static final int ARRAY_SIZE = 10_000_000;
    private static final Random RANDOM = new Random();

    private IRearrangeArray victim1;
    private IRearrangeArray victim2;
    private int[] sortedArray;
    private int[] mixedArray;

    @Setup
    public void setup() {
        victim1 = new RearrangeArrayOptionOne();
        victim2 = new RearrangeArrayOptionTwo();
        sortedArray = IntStream.range(0, ARRAY_SIZE).toArray();
        mixedArray = IntStream.rangeClosed(0, ARRAY_SIZE)
                .map(i -> RANDOM.nextInt(ARRAY_SIZE))
                .toArray();
    }

    @Benchmark
    public void testRearrangeArrayElementsSortedVictim1() {
        victim1.rearrangeArray(sortedArray);
    }

    @Benchmark
    public void testRearrangeArrayElementsSortedVictim2() {
        victim2.rearrangeArray(sortedArray);
    }

    @Benchmark
    public void testRearrangeArrayElementsMixedVictim1() {
        victim1.rearrangeArray(mixedArray);
    }

    @Benchmark
    public void testRearrangeArrayElementsMixedVictim2() {
        victim2.rearrangeArray(mixedArray);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(RearrangeArrayJmhTests.class.getSimpleName())
                .warmupIterations(2)
                .measurementIterations(2)
                .forks(2)
                .build();

        new Runner(opt).run();
    }
}
