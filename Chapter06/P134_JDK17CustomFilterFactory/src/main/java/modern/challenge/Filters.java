package modern.challenge;

import java.io.ObjectInputFilter;

public final class Filters {

    private Filters() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static ObjectInputFilter allowFilter() {

        ObjectInputFilter filter = ObjectInputFilter.allowFilter(                        
                clazz -> Melon.class.isAssignableFrom(clazz),
                ObjectInputFilter.Status.REJECTED);

        return filter;
    }
    
    public static ObjectInputFilter rejectFilter() {

        ObjectInputFilter filter = ObjectInputFilter.rejectFilter(                        
                clazz -> Muskmelons.class.isAssignableFrom(clazz),
                ObjectInputFilter.Status.UNDECIDED);

        return filter;
    }
    
    public static ObjectInputFilter packageFilter() {
        
        return ObjectInputFilter.Config.createFilter(
                  "modern.challenge.*;!*");
    }
}