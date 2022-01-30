package streams.examples;

import org.junit.jupiter.api.Test;
import streams.beans.Car;
import streams.mockdata.MockData;

import java.io.IOException;
import java.util.DoubleSummaryStatistics;
import java.util.List;

public class StatisticsWithStreams {

    // count number of ford cars manufactured after 2010
    // min price of a car
    // max price of a car

    @Test
    public void count() throws IOException {
        List<Car> cars = MockData.getCars();
        long count = cars.stream()
                .filter(car -> car.getMake()
                        .equalsIgnoreCase("Ford"))
                .filter(car -> car.getYear() > 2010)
                .count();

        System.out.println(count);
    }

    @Test
    public void min() throws IOException {
        List<Car> cars = MockData.getCars();
        double minPrice = cars.stream()
                .mapToDouble(Car::getPrice)
                .min()
                .orElse(0);
        System.out.println("Min :" + minPrice);
    }

    @Test
    public void max() throws IOException {
        List<Car> cars = MockData.getCars();
        double maxPrice = cars.stream()
                .mapToDouble(Car::getPrice)
                .max()
                .orElse(0);
        System.out.println("Max : " + maxPrice);
    }

    @Test
    public void avg() throws IOException {
        List<Car> cars = MockData.getCars();
        double avgPrice = cars.stream()
                .mapToDouble(Car::getPrice)
                .average()
                .orElse(0);
        System.out.println("Average : " + avgPrice);
    }

    @Test
    public void stat() throws IOException {
        List<Car> cars = MockData.getCars();
        DoubleSummaryStatistics statistics = cars.stream()
                .mapToDouble(Car::getPrice)
                .summaryStatistics();
        System.out.println("Average : " + statistics.getAverage());
        System.out.println("Count : " + statistics.getCount());
        System.out.println("Max : " + statistics.getMax());
        System.out.println("Min : " + statistics.getMin());
        System.out.println("Sum : " + statistics.getSum());
    }

}
