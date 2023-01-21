package modern.challenge;

import java.util.List;

public class Main {

    public static void main(String[] args) {      
      
        new Main().print(List.of(new A(), new A()));
        new Main().print(List.of(new B(), new B()));
    }    
  
    void print(List<A> listOfA, Void... v) {
        System.out.println("Printing A: " + listOfA);
    }
    
    void print(List<B> listofB) {
        System.out.println("Printing B: " + listofB);
    }
}


