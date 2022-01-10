package streams.examples;

import org.junit.jupiter.api.Test;
import streams.beans.Person;
import streams.mockdata.MockData;

import java.io.IOException;

public class StreamsExample {

    @Test
    public void understandingCollect() throws IOException {
        MockData.getPeople()
                .stream()
                .map(Person::getEmail)
                .toList()
                .forEach(System.out::println);
    }

}
