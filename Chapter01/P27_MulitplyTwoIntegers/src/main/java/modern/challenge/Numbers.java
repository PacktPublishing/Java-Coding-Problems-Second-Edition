package modern.challenge;

public final class Numbers {

    private Numbers() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static int multiplyV1(int p, int q) {

        // p * 0 = 0
        if (q == 0) {
            return 0;
        }

        // adding 'p' one-by-one
        if (q > 0) {
            return (p + multiplyV1(p, q - 1));
        }

        // if 'q' is negative
        if (q < 0) {
            return -multiplyV1(p, -q);
        }

        return -1;
    }

    public static int multiplyV2(int p, int q) {

        // p * 0 = 0, 0 * q = 0
        if (p == 0 || q == 0) {
            return 0;
        }

        int pqSquare = (int) Math.pow(p + q, 2);
        int pSquare = (int) Math.pow(p, 2);
        int qSquare = (int) Math.pow(q, 2);

        int squareResult = pqSquare - pSquare - qSquare;

        int result;

        if (squareResult >= 0) {
            result = divideByTwo(squareResult);
        } else {
            result = 0 - divideByTwo(Math.abs(squareResult));
        }

        return result;
    }

    // recursion used to divide a number by 2
    private static int divideByTwo(int d) {

        if (d < 2) {
            return 0;
        }

        return 1 + divideByTwo(d - 2);
    }
}
