package modern.challenge;

import java.awt.Point;

/**
 * A telemeter with laser ranging from 0 to 60 ft including calculation of
 * surfaces and volumes with high-precision
 *
 * <pre>{@code
 *     Telemeter.Calibrate.at(0.00001);
 *     Telemeter telemeter = new Telemeter(0.15, 2, "IP54");
 * }</pre>
 */
public class Telemeter {

    private final double precision;
    private final int clazz;
    private final String protection;

    /**
     * Telemeter constructor
     * 
     * @param precision telemeter precision (for instance, 0.15 millimeters)
     * @param clazz telemeter class (for instance, 1 or 2)
     * @param protection telemeter protection (for instance, IP54)
     */
    public Telemeter(double precision, int clazz, String protection) {
        this.precision = precision;
        this.clazz = clazz;
        this.protection = protection;
    }

    /**
     * Method for calculating the distance between two points
     * 
     * @param sc from this point
     * @param ec to this point
     * @param interpolation use interpolation or not
     * @return the computed distance as integer
     * 
     * <p><b>Example:</b></p>
     * <pre>{@code     
     *    Point sp = new Point(12, 56);
     *    Point ep = new Point(43, 45);
     * 
     *    int d = telementer.distance(sp, ep, true);
     * }</pre>
     */
    public int distance(Point sc, Point ec, boolean interpolation) {

        return 0;
    }

    /**
     * Class used to calibrate the telemeter      
     */
    public static final class Calibrate {
        
        /**
         * Cannot be instantiated
         */
        private Calibrate() {
            throw new AssertionError("Cannot be instantiated");
        }

        /**
         * Method used for calibrating the telemeter to the given epsilon
         * (for instance, eps = 0.00001)
         * 
         * @param eps the telemeter is calibrated to this precision
         * @param type the type of calibration
         * @return true, if calibration was done with success
         * 
         * <p>
         * {@code Telemeter.Calibrate.at(0.00001);}
         * </p>
         * 
         * PERFORM THE CALIBRATION BEFORE CREATING AN INSTANCE OF THIS CLASS
         */
        public static boolean at(double eps, String type) {

            return true;
        }
    }
}
