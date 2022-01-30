package java8.interfacedemo.defaultpkg;

public interface DefaultInterface {
    double calculate(int a);
    double add(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}
