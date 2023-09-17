package modern.challenge;

// strictfp is not required starting with Java 17
@SuppressWarnings("unchecked")
public class Main implements Rectangle {

    public static void main(String[] args) {

        double alfa = Rectangle.Trigonometry.smallAngleOfDiagonals(10, 5);
        double beta = Rectangle.Trigonometry.bigAngleOfDiagonals(10, 5);

        System.out.println("Small angle (alfa): " + alfa + " degree");
        System.out.println("Big angle (beta): " + beta + " degree");
    }

    @Override
    strictfp public double diagonal(double length, double width) {

        return Math.sqrt((length * length) + (width * width));
    }

    strictfp public double perimeter(double length, double width) {

        return 2.0d * length + 2.0d * width;
    }
}
