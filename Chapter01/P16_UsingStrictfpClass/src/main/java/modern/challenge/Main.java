package modern.challenge;

public class Main {

    public static void main(String[] args) {

        double x = 0.8793331;
        double y = 12.22933;
        double z = 901.98334884433;
        double a1 = (x + y) + z;
        double a2 = (x + (y + z));
        double m1 = (x * y) * z;
        double m2 = (x * (y * z));

        System.out.println("Associativity of addition: " + a1 + " = " + a2);
        System.out.println("Associativity of addition: " + (a1 == a2));
        System.out.println("Associativity of multiplication: " + m1 + " = " + m2);
        System.out.println("Associativity of multiplication: " + (m1 == m2));

        double mresult = ScientificCalculator.multiply(11e+09, 7e+06);
        double dresult = ScientificCalculator.division(11e+09, 7e+06);

        System.out.println("Multiply result: " + mresult);
        System.out.println("Division result: " + dresult);
    }
}
