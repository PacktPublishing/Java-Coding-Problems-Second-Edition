package modern.challenge;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {      
      
       List<Object> list = listOf(1, "one");
       System.out.println(list);
    }    
   
   public static <T, R extends T> List<T> listOf(T t, R r) {
       
       List<T> list = new ArrayList<>();
       
       list.add(t);
       list.add(r);       
       
       return list;
               
   }
}


