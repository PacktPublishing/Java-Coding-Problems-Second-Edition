package modern.challenge;

import com.google.common.math.DoubleMath;

public final class Numbers {

    private Numbers() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static boolean isDoubleIntegerV1(double v) {

        return v == (int) v;
    }

    public static boolean isDoubleIntegerV2(double v) {

        return v % 1 == 0;
    }

    public static boolean isDoubleIntegerV3(double v) {

        return ((Math.floor(v) == v) && Double.isFinite(v));
    }

    public static boolean isDoubleIntegerV4(double v) {

        return (Math.floor(v) == Math.ceil(v) && Double.isFinite(v));
    }

    public static boolean isDoubleIntegerV5(double v) {

        return ((Math.rint(v) == v) && Double.isFinite(v));
    }

    // using Guava implementation
    public static boolean isDoubleIntegerV6(double v) {

        return DoubleMath.isMathematicalInteger(v);
    }
}
