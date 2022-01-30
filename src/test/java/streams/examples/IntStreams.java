package streams.examples;

import org.junit.jupiter.api.Test;
import streams.beans.Person;
import streams.mockdata.MockData;

import java.util.List;
import java.util.stream.IntStream;

public class IntStreams {

    @Test
    public void range() {
        // print number from 1 to 10

        for (int i = 0; i <= 10; i++) {
            System.out.print(i);
        }
        System.out.println();
        IntStream.range(0,10).forEach(System.out::print);

        System.out.println();
        IntStream.rangeClosed(0,10).forEach(System.out::print);

    }

    @Test
    public void rangeIteratingLists() throws Exception {
        List<Person> personList = MockData.getPeople();
        IntStream.range(0, personList.size()).limit(5).forEach(index -> System.out.println(personList.get(index)));
    }
}
