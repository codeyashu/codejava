package streams.examples;

import org.junit.jupiter.api.Test;
import streams.beans.Car;
import streams.beans.Person;
import streams.mockdata.MockData;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class Sorting {
    //sorting based on first name
    // sorting in reverse order
    // top ten expensive blue car

    @Test
    public void sortByFirstName() throws IOException {
        List<Person> people = MockData.getPeople();

        people.stream()
                .map(Person::getFirstName)
                .sorted()
                .toList()
                .forEach(System.out::println);
    }

    @Test
    public void sortByFirstNameReverseOrder() throws IOException {
        List<Person> people = MockData.getPeople();

        people.stream()
                .map(Person::getFirstName)
                .sorted(Comparator.reverseOrder())
                .toList()
                .forEach(System.out::println);
    }

    @Test
    public void sortingSteamOfObjets() throws IOException {
        List<Person> people = MockData.getPeople();
        Comparator<Person> personComparator = Comparator.comparing(Person::getEmail)
                .reversed()
                .thenComparing(Person::getFirstName);

        people.stream()
                .sorted(personComparator)
                .toList()
                .forEach(System.out::println);
    }

    @Test
    public void topTenExpensiveCar() throws IOException {
        List<Car> cars = MockData.getCars();

        cars.stream()
                .filter(car -> car.getColor()
                        .equalsIgnoreCase("Blue"))
                .sorted(Comparator.comparing(Car::getPrice)
                        .reversed())
                .toList()
                .stream()
                .limit(10)
                .forEach(System.out::println);
    }
}
