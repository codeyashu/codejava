package streams.examples;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class IterableToStream {

    @Test
    public void iterable(){
        Iterable<String> iterable = Arrays.asList("Testing", "Iterable", "conversion", "to", "Stream");
        StreamSupport.stream(iterable.spliterator(), false);
    }

    @Test
    public void peekPrint(){
        List<String> strings = Stream.of("one", "two", "three", "four")
                .filter(s -> s.length() > 3)
                .peek(s -> System.out.println("Filtered values : " + s))
                .map(String::toUpperCase)
                .peek(s -> System.out.println("Mapped values : " + s))
                .toList();



    }
}
