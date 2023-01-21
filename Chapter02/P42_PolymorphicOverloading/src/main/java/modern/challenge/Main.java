package modern.challenge;

import java.io.File;

public class Main {
    
    static String wordie = "";

    public static void main(String[] args) {      
            
      kaboom(1);                   // c
      kaboom(1d);                  // g
      kaboom((short) 1);           // b
      kaboom(1L);                  // d      
      kaboom(Double.valueOf("1")); // m
      kaboom(true);                // n
      kaboom();                    // r
      kaboom(1L, true);            // p
      kaboom(new int[]{1,2,3}, 1); // p            
      
      System.out.println("Wordie:"+wordie); // cgbdmnrpp
    }           
    
   static void kaboom(byte b) { wordie += "a";}   
   static void kaboom(short s) { wordie += "b";}   
   static void kaboom(int i) { wordie += "c";}   
   static void kaboom(long l) { wordie += "d";}   
   static void kaboom(float f) { wordie += "f";} 
   static void kaboom(double d) { wordie += "g";} 
   
   static void kaboom(Byte b) { wordie += "h";}   
   static void kaboom(Short s) { wordie += "i";}   
   static void kaboom(Integer i) { wordie += "j";}   
   static void kaboom(Long l) { wordie += "k";}   
   static void kaboom(Float f) { wordie += "l";} 
   static void kaboom(Double d) { wordie += "m";}
   
   static void kaboom(boolean o) { wordie += "n";}      
   static void kaboom(Object o) { wordie += "o";}   
   static void kaboom(Object... ov) { wordie += "p";}   
   static void kaboom(File... w) { wordie += "r";}   
}
