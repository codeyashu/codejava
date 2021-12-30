package streams.examples;

import org.junit.jupiter.api.Test;
import streams.beans.Car;
import streams.mockdata.MockData;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Filtering {

    @Test
    public void filterCar() throws IOException {
        // filter yellow car with proce less than 2000.00
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
