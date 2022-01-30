package java8.interfacedemo.defaultpkg;

public class Formula {

    public static void main(String[] args) {
        DefaultInterface defaultInterface = new DefaultInterface() {
            @Override
            public double calculate(int a) {
                System.out.println("a");
                return a * a;
            }

            @Override
            public double add(int a) {
                return a + a;
            }
        };

        System.out.println(defaultInterface.calculate(2));
        System.out.println(defaultInterface.add(2));
        double sqrt = defaultInterface.sqrt(2);
        System.out.println(sqrt);
    }
}
