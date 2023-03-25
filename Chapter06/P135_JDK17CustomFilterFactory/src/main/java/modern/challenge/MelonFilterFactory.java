package modern.challenge;

import java.io.ObjectInputFilter;
import java.util.function.BinaryOperator;

public class MelonFilterFactory implements BinaryOperator<ObjectInputFilter> {

    @Override
    public ObjectInputFilter apply(ObjectInputFilter t, ObjectInputFilter u) {

        System.out.println();
        System.out.println("Current filter: " + t);
        System.out.println("Requested filter: " + u);

        if (t == null) {            
            return ObjectInputFilter.merge(u, Filters.packageFilter());
        }

        return ObjectInputFilter.merge(u, t);
    }
}
