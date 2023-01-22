package modern.challenge;

public class Main {

    public static void main(String[] args) {

        String str = "start";
        
        str = stopItWrong(str);
        System.out.println("Stop it (wrong): " + str);
        
        str = stopItGood(str);
        System.out.println("Stop it (wrong): " + str);
    }
    
    public static String stopItWrong(String str) {
        
        str.replace(str, "stop");                        
        
        return str;
    }
    
    public static String stopItGood(String str) {
        
        str =  str.replace(str, "stop");                        
        
        return str;
    }
}