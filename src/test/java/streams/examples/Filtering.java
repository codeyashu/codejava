package streams.examples;

import org.junit.jupiter.api.Test;
import streams.beans.Car;
import streams.mockdata.MockData;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class Filtering {

    {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> result = list.stream()
                .parallel()
                .filter(num -> num < 4)
                .findAny();

        assertTrue(result.isPresent());
        assertThat(result.get(), anyOf(is(1), is(2), is(3)));
    }

    @Test
    public void filterCar() throws IOException {
        // filter yellow car with price less than 2000.00
        List<Car> carList = MockData.getCars();

        carList.stream()
                .filter(car -> car.getPrice() < 20000.00)
                .filter(car -> car.getColor()
                        .equals("Yellow"))
                .toList()
                .forEach(System.out::println);
    }

    @Test
    public void dropWhile() {
        System.out.println("using filter");
        Stream.of(2, 4, 6, 8, 9, 10, 12)
                .filter(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();
        System.out.println("using dropWhile");
        Stream.of(2, 4, 6, 8, 9, 10, 12)
                .dropWhile(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));

    }

    @Test
    public void takeWhile() {
        System.out.println("using filter");
        Stream.of(2, 4, 6, 8, 9, 10, 12)
                .filter(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();
        System.out.println("using takeWhile");
        Stream.of(2, 4, 6, 8, 9, 10, 12)
                .takeWhile(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));

    }

    // finds first element for parallel/non-parallel stream
    @Test
    public void findFirst() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int result = Arrays.stream(numbers)
                .filter(n -> n == 7)
                .findFirst()
                .orElse(-1);

        System.out.println(result);

    }

    @Test
    public void findAny() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 10};
        int result = Arrays.stream(numbers)
                .filter(n -> n == 9)
                .findAny()
                .orElse(-1);
        System.out.println(result);
    }

    @Test
    public void createStream_whenFindAnyResultIsPresent_thenCorrect() {

        //finds any element which matches the criteria in the list
        // in non-parallel it will most likely first element
        // with parallel stream element at random position is picked
        List<String> list = Arrays.asList("A", "B", "C", "D");

        Optional<String> result = list.stream()
                .findAny();

        assertTrue(result.isPresent());
        assertThat(result.get(), anyOf(is("A"), is("B"), is("C"), is("D")));
    }


    @Test
    public void createParallelStream_whenFindAnyResultIsPresent_thenCorrect() throws Exception {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> result = list.stream()
                .parallel()
                .filter(num -> num < 4)
                .findAny();

        assertTrue(result.isPresent());
        assertThat(result.get(), anyOf(is(1), is(2), is(3)));
    }

    @Test
    public void allMatch() {
        int[] even = {2, 4, 6, 8, 10};
        boolean allMatch = Arrays.stream(even)
                .allMatch(n -> n % 2 == 0);
        System.out.println(allMatch);
    }

    @Test
    public void anyMatch() {
        int[] evenAndOneOdd = {2, 4, 6, 8, 10, 11};
        boolean anyMatch = Arrays.stream(evenAndOneOdd)
                .anyMatch(n -> !(n % 2 == 0));
        System.out.println(anyMatch);
    }

}
