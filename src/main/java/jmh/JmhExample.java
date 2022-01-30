package jmh;

import org.openjdk.jmh.annotations.Benchmark;

public class JmhExample {
    @Benchmark
    public void init() {
        // Do nothing
    }

    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }

}
