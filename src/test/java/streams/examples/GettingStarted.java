package streams.examples;

import org.junit.jupiter.api.Test;
import streams.beans.Person;
import streams.mockdata.MockData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GettingStarted {

    @Test
    public void imperativeApproach() throws IOException {
        // 1. Find people aged less or equal 18
        // 2. Then change implementation to find first 10 people

        List<Person> people = MockData.getPeople();
        List<Person> youngPeople = new ArrayList<>();

        int limit = 10;
        int counter = 0;
        for (Person person : people) {
            if (person.getAge() <= 18) {
                youngPeople.add(person);
                counter++;
                if (counter == limit) break;
            }
        }

        for (Person youPerson : youngPeople) {
            System.out.println(youPerson);
        }

    }

    @Test
    public void declarativeApproach() throws IOException {
        List<Person> people = MockData.getPeople();
        people.stream()
                .filter(person -> person.getAge() <= 18)
                .limit(10)
                .toList()
                .forEach(System.out::println);
    }
}
