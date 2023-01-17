package modern.challenge;

import java.io.IOException;
import java.util.Objects;

public class Main {    

    public static void main(String[] args) throws IOException {
         
        MyPoint p = new MyPoint(1, 2, 3);
        
        System.out.println("Objects.toIdentityString(): " 
                + Objects.toIdentityString(p));      
        
        System.out.println("p.toString(): "
                + p.toString());                 
        
        System.out.println("Integer.toHexString(p.hashCode()): " 
                + Integer.toHexString(p.hashCode()));
    }
}
