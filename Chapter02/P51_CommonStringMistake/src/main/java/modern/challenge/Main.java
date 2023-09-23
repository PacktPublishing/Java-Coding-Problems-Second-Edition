package modern.challenge;

public class Main {

    public static void main(String[] args) {

        String str = "start";
        
        str = stopItWrong(str);
        System.out.println("Stop it (wrong): " + str);
        
        str = stopItGood1(str); // or, stopItGood2(str)
        System.out.println("Stop it (good): " + str);
    }
    
    public static String stopItWrong(String str) {
        
        str.replace(str, "stop");                        
        
        return str;
    }
    
    public static String stopItGood1(String str) {
        
        str =  str.replace(str, "stop");                        
        
        return str;
    }
    
    public static String stopItGood2(String str) {
        
        return str.replace(str, "stop");                                
    }
}