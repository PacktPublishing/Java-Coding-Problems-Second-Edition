package modern.challenge;

public class Main {

    public static void main(String[] args) {

        double v1 = 23.11;
        double v2 = 23;
        double v3 = 23.0;
        double v4 = Double.NaN;
        double v5 = Double.NEGATIVE_INFINITY;
        double v6 = Double.POSITIVE_INFINITY;

        System.out.println("-------------------------------------------------");
        System.out.println("USING CAST:");
        System.out.println("-------------------------------------------------");
        System.out.println("'v1 (23.11)' is integer ?: "
                + Numbers.isDoubleIntegerV1(v1));
        System.out.println("'v2 (23)' is integer ?: "
                + Numbers.isDoubleIntegerV1(v2));
        System.out.println("'v3 (23.0)' is integer ?: "
                + Numbers.isDoubleIntegerV1(v3));
        System.out.println("'v4 (NaN)' is integer ?: "
                + Numbers.isDoubleIntegerV1(v4));
        System.out.println("'v5 (NEGATIVE_INFINITY)' is integer ?: "
                + Numbers.isDoubleIntegerV1(v5));
        System.out.println("'v6 (POSITIVE_INFINITY)' is integer ?: "
                + Numbers.isDoubleIntegerV1(v6));
        System.out.println("-------------------------------------------------");

        System.out.println();
        System.out.println("-------------------------------------------------");
        System.out.println("USING MODULO (%):");
        System.out.println("-------------------------------------------------");
        System.out.println("'v1 (23.11)' is integer ?: "
                + Numbers.isDoubleIntegerV2(v1));
        System.out.println("'v2 (23)' is integer ?: "
                + Numbers.isDoubleIntegerV2(v2));
        System.out.println("'v3 (23.0)' is integer ?: "
                + Numbers.isDoubleIntegerV2(v3));
        System.out.println("'v4 (NaN)' is integer ?: "
                + Numbers.isDoubleIntegerV2(v4));
        System.out.println("'v5 (NEGATIVE_INFINITY)' is integer ?: "
                + Numbers.isDoubleIntegerV2(v5));
        System.out.println("'v6 (POSITIVE_INFINITY)' is integer ?: "
                + Numbers.isDoubleIntegerV2(v6));
        System.out.println("-------------------------------------------------");

        System.out.println();
        System.out.println("-------------------------------------------------");
        System.out.println("USING Math.floor() AND Double.isFinite():");
        System.out.println("-------------------------------------------------");
        System.out.println("'v1 (23.11)' is integer ?: "
                + Numbers.isDoubleIntegerV3(v1));
        System.out.println("'v2 (23)' is integer ?: "
                + Numbers.isDoubleIntegerV3(v2));
        System.out.println("'v3 (23.0)' is integer ?: "
                + Numbers.isDoubleIntegerV3(v3));
        System.out.println("'v4 (NaN)' is integer ?: "
                + Numbers.isDoubleIntegerV3(v4));
        System.out.println("'v5 (NEGATIVE_INFINITY)' is integer ?: "
                + Numbers.isDoubleIntegerV3(v5));
        System.out.println("'v6 (POSITIVE_INFINITY)' is integer ?: "
                + Numbers.isDoubleIntegerV3(v6));
        System.out.println("-------------------------------------------------");

        System.out.println();
        System.out.println("-------------------------------------------------");
        System.out.println("USING Math.floor(), Math.ceil() AND Double.isFinite():");
        System.out.println("-------------------------------------------------");
        System.out.println("'v1 (23.11)' is integer ?: "
                + Numbers.isDoubleIntegerV4(v1));
        System.out.println("'v2 (23)' is integer ?: "
                + Numbers.isDoubleIntegerV4(v2));
        System.out.println("'v3 (23.0)' is integer ?: "
                + Numbers.isDoubleIntegerV4(v3));
        System.out.println("'v4 (NaN)' is integer ?: "
                + Numbers.isDoubleIntegerV4(v4));
        System.out.println("'v5 (NEGATIVE_INFINITY)' is integer ?: "
                + Numbers.isDoubleIntegerV4(v5));
        System.out.println("'v6 (POSITIVE_INFINITY)' is integer ?: "
                + Numbers.isDoubleIntegerV4(v6));
        System.out.println("-------------------------------------------------");

        System.out.println();
        System.out.println("-------------------------------------------------");
        System.out.println("USING Math.rint() AND Double.isFinite():");
        System.out.println("-------------------------------------------------");
        System.out.println("'v1 (23.11)' is integer ?: "
                + Numbers.isDoubleIntegerV5(v1));
        System.out.println("'v2 (23)' is integer ?: "
                + Numbers.isDoubleIntegerV5(v2));
        System.out.println("'v3 (23.0)' is integer ?: "
                + Numbers.isDoubleIntegerV5(v3));
        System.out.println("'v4 (NaN)' is integer ?: "
                + Numbers.isDoubleIntegerV5(v4));
        System.out.println("'v5 (NEGATIVE_INFINITY)' is integer ?: "
                + Numbers.isDoubleIntegerV5(v5));
        System.out.println("'v6 (POSITIVE_INFINITY)' is integer ?: "
                + Numbers.isDoubleIntegerV5(v6));
        System.out.println("-------------------------------------------------");

        System.out.println();
        System.out.println("-------------------------------------------------");
        System.out.println("USING GUAVA:");
        System.out.println("-------------------------------------------------");
        System.out.println("'v1 (23.11)' is integer ?: "
                + Numbers.isDoubleIntegerV6(v1));
        System.out.println("'v2 (23)' is integer ?: "
                + Numbers.isDoubleIntegerV6(v2));
        System.out.println("'v3 (23.0)' is integer ?: "
                + Numbers.isDoubleIntegerV6(v3));
        System.out.println("'v4 (NaN)' is integer ?: "
                + Numbers.isDoubleIntegerV6(v4));
        System.out.println("'v5 (NEGATIVE_INFINITY)' is integer ?: "
                + Numbers.isDoubleIntegerV6(v5));
        System.out.println("'v6 (POSITIVE_INFINITY)' is integer ?: "
                + Numbers.isDoubleIntegerV6(v6));
        System.out.println("-------------------------------------------------");
    }
}
