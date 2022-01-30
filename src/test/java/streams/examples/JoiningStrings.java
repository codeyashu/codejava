package streams.examples;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class JoiningStrings {

    @Test
    public void joiningStrings(){
        List<String> names = List.of("anna", "john", "marcos", "helena", "yasmin");

        StringBuilder join = new StringBuilder();
        for (String name: names){
            join.append(name.substring(0,1).toUpperCase())
                    .append(name.substring(1))
                    .append(",");
        }

        System.out.println(join);
        System.out.println(join.substring(0,join.length()-1));

    }

    @Test
    public void joiningStringsWithStream() throws Exception {
        List<String> names = List.of("anna", "john", "marcos", "helena", "yasmin");
        String name = names.stream()
                .map(s -> s.substring(0, 1)
                        .toUpperCase() + s.substring(1))
                .collect(Collectors.joining(","));

        System.out.println(name);

    }
}
