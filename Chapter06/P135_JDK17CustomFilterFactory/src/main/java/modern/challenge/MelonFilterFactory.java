package modern.challenge;

import java.io.ObjectInputFilter;
import java.util.function.BinaryOperator;

public class MelonFilterFactory implements BinaryOperator<ObjectInputFilter> {

    @Override
    public ObjectInputFilter apply(ObjectInputFilter current, ObjectInputFilter next) {
        
        System.out.println();
        System.out.println("Current filter: " + current);
        System.out.println("Requested filter: " + next);

        if (current == null && next != null) {                    
            return ObjectInputFilter.merge(next, Filters.packageFilter());
        }

        return ObjectInputFilter.merge(next, current);
    }
}
