package modern.challenge;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public final class Numbers {

    private Numbers() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static float roundToDecimalsV1(float v, int decimals) {

        if (decimals < 0) {
            throw new IllegalArgumentException("Number of decimals must be a positive integer");
        }

        BigDecimal bd = new BigDecimal(Float.toString(v));
        bd = bd.setScale(decimals, RoundingMode.HALF_UP);

        return bd.floatValue();
    }

    public static float roundToDecimalsV2(float v, int decimals) {

        if (decimals < 0) {
            throw new IllegalArgumentException("Number of decimals must be a positive integer");
        }

        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(decimals);

        return Float.parseFloat(df.format(v));
    }

    public static float roundToDecimalsV3(float v, int decimals) {

        if (decimals < 0) {
            throw new IllegalArgumentException("Number of decimals must be a positive integer");
        }

        int factor = Integer.parseInt("1".concat("0".repeat(decimals)));

        return (float) Math.round(v * factor) / factor;
    }
    
    public static float roundToDecimalsV4(float v, int decimals) {

        if (decimals < 0) {
            throw new IllegalArgumentException("Number of decimals must be a positive integer");
        }
 
        StringBuilder sb = new StringBuilder();
        sb.append("1")
          .repeat("0", decimals);          
        
        int factor = Integer.parseInt(sb.toString());

        return (float) Math.round(v * factor) / factor;
    }
}
