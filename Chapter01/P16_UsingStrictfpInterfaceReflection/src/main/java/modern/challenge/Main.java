package modern.challenge;

import java.lang.reflect.Modifier;

// strictfp is not required starting with Java 17
@SuppressWarnings("unchecked")
public class Main implements Rectangle {

    public static void main(String[] args) {

        displayModifiers(Main.class, "diagonal");
        displayModifiers(Main.class, "perimeter");
        displayModifiers(Main.class.getInterfaces()[0], "diagonal");
        displayModifiers(Main.class.getInterfaces()[0], "area");
        displayModifiers(Rectangle.Trigonometry.class, "smallAngleOfDiagonals");
        displayModifiers(Rectangle.Trigonometry.class, "bigAngleOfDiagonals");
    }

    @Override
    public double diagonal(double length, double width) { // needs explicit strictfp

        return Math.sqrt((length * length) + (width * width));
    }

    public double perimeter(double length, double width) { // needs explicit strictfp

        return 2.0d * length + 2.0d * width;
    }

    public static void displayModifiers(Class clazz, String member) {
        try {
            int modifiers = clazz.getDeclaredMethod(member, double.class, double.class).getModifiers();
            System.out.println(member + " has the following modifiers: " + Modifier.toString(modifiers));
        } catch (NoSuchMethodException | SecurityException e) {
            e.printStackTrace(System.out);
        }
    }
}
