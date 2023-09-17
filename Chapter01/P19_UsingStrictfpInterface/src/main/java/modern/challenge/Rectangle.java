package modern.challenge;

// strictfp is not required starting with Java 17
public strictfp interface Rectangle {
    
    default double area(double length, double width) {
        
        return length * width;
    }           
        
    double diagonal(double length, double width);
    
    public class Trigonometry {      
                
        public static double smallAngleOfDiagonals(double length, double width) {
            
            double delta = Math.atan(length / width);
            double alfa = Math.PI - 2.0d * delta;
            
            return alfa * 180.0d / Math.PI;
        }
        
        public static double bigAngleOfDiagonals(double length, double width) {
            
            double delta = Math.atan(width / length);
            double beta = Math.PI - 2.0d * delta;
            
            return beta * 180.0d / Math.PI;
        }
    }
}