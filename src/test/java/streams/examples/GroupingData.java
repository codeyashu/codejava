package streams.examples;

import org.junit.jupiter.api.Test;
import streams.beans.Car;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static streams.mockdata.MockData.getCars;

public class GroupingData {

    @Test
    public void groupCarsByMake() throws IOException {
        //fetch list of cars
        List<Car> carList = getCars();
        //group list of cars by make
        //print each car

//        carList.stream()
//                .collect(Collectors.groupingBy(Car::getMake))
//                .forEach((s, cars) -> System.out.println(cars));

        Map<String, List<Car>> listMap = carList.stream()
                .collect(Collectors.groupingBy(Car::getMake));

        listMap.forEach((s, cars) -> System.out.println(s));

    }

    @Test
    public void groupingAndCounting() {
        List<String> names = List.of("John", "John", "Mariam", "Alex", "Mohammado", "Mohammado", "Vincent", "Alex", "Alex");

        Map<String, Long> map = names.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));


        System.out.println(map);

    }
}
