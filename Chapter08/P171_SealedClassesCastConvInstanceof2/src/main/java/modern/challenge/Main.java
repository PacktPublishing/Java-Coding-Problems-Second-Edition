package modern.challenge;

public class Main {  
     
    public static void drawTriangle (Triangle t) {
        
        // if(t instanceof Quadrilateral) { // the compiler knows that Triangle cannot be extended and cannot be an instance of Quadrilateral
        //    System.out.println("This is not a triangle");
        // } else {
        System.out.println("Drawing a triangle"); // this is the single option (t cannot be something else than a Triangle)
        // }
    }

    public static void main(String[] args) {}
}