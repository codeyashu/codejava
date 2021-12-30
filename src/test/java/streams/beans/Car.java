package streams.beans;

import lombok.Data;

@Data
public class Car {

    private final Integer id;
    private final String make;
    private final String model;
    private final String color;
    private final Integer year;
    private final Double price;


}
