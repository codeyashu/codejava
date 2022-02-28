package streams.examples;

import org.junit.jupiter.api.Test;
import streams.beans.Person;
import streams.beans.PersonDTO;
import streams.mockdata.MockData;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TransformationsMapAndReduce {
    //Map<String, Map<String, List<Person>>> peopleByStateAndCity = personStream.collect(Collectors.groupingBy(Person::getState, Collectors.groupingBy(Person::getCity)));

    private static int divide(int value, int factor) {
        int result = 0;
        try {
            result = value / factor;
        } catch (ArithmeticException e) {
            System.err.println("Arithmetic Exception: Division by Zero");
        }
        return result;
    }

    @Test
    void yourFirstTransformationWithMap() throws IOException {
        List<Person> people = MockData.getPeople();

        Function<Person, PersonDTO> personPersonDTOFunction = person -> new PersonDTO(person.getId(), person.getFirstName(), person.getAge());

        List<PersonDTO> dtos = people.stream()
                .filter(person -> person.getAge() > 20)
                .map(personPersonDTOFunction)
                .toList();

        dtos.forEach(System.out::println);

    }

    @Test
    public void collect() throws IOException {
        List<Person> people = MockData.getPeople();

        people.stream()
                .limit(50)
                .collect(Collectors.groupingBy(Person::getGender, Collectors.groupingBy(Person::getAge)))
                .forEach((s, people1) -> System.out.println("Key is " + s + "----" + people1));

        //  list of male and female, in which it is again grouped by age

    }

    @Test
    public void reduce() {
        int[] integers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum = Arrays.stream(integers)
                .reduce(0, Integer::sum);
        int sub = Arrays.stream(integers)
                .reduce(0, (a, b) -> a - b);
        System.out.println(sum);
        System.out.println(sub);
    }

    @Test
    public void divider() {
        List<Integer> integerList = Arrays.asList(0, 1, 2, 3, 4, 5, 6);
        int divider = 2;

        Integer result = integerList.stream()
                .reduce(0, (a, b) -> divide(a, divider) + divide(b, divider));
        System.out.println(result);
    }

}
