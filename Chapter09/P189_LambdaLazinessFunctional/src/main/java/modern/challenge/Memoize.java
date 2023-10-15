package modern.challenge;

import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public class Memoize {

    private final static Object UNDEFINED = new Object();

    public static <T> FSupplier<T> supplier(final Supplier<T> supplier) {
       
        AtomicReference cache = new AtomicReference<>(UNDEFINED);       
      
        return () -> {                        
            
            Object value = cache.get();            
            
            if (value == UNDEFINED) {                
                
                synchronized (cache) {
                    
                    if (cache.get() == UNDEFINED) {
                        
                        System.out.println("Caching: " +  supplier.get());
                        value = supplier.get();
                        cache.set(value);
                    }
                }
            }
            
            return (T) value;
        };
    }
}