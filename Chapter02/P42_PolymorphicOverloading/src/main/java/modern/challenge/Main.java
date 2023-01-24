package modern.challenge;

import java.io.File;

public class Main {
    
    static String wordie = "";

    public static void main(String[] args) {      
            
      kaboom(1);                   // c
      kaboom(1, 2, 3);             // q
      kaboom(1d);                  // f
      kaboom((short) 1);           // b
      kaboom(1L);                  // d      
      kaboom(Double.valueOf("1")); // l
      kaboom(true);                // m
      // kaboom()                  // reference to kaboom is ambiguous
      kaboom(1L, true);            // o
      kaboom(new int[]{1,2,3}, 1); // o            
      
      System.out.println("Wordie:"+wordie); // cqfbdlmoo
    }           
    
   static void kaboom(byte b) { wordie += "a";}   
   static void kaboom(short s) { wordie += "b";}   
   static void kaboom(int i) { wordie += "c";}   
   static void kaboom(long l) { wordie += "d";}   
   static void kaboom(float f) { wordie += "e";} 
   static void kaboom(double d) { wordie += "f";} 
   
   static void kaboom(Byte b) { wordie += "g";}   
   static void kaboom(Short s) { wordie += "h";}   
   static void kaboom(Integer i) { wordie += "i";}   
   static void kaboom(Long l) { wordie += "j";}   
   static void kaboom(Float f) { wordie += "k";} 
   static void kaboom(Double d) { wordie += "l";}
   
   static void kaboom(boolean o) { wordie += "m";}      
   static void kaboom(Object o) { wordie += "n";}   
   static void kaboom(Object... ov) { wordie += "o";}   
   static void kaboom(Number n) { wordie += "p";}   
   static void kaboom(Number... nv) { wordie += "q";}   
   static void kaboom(File f) { wordie += "r";}   
   static void kaboom(File... fv) { wordie += "s";}   
}