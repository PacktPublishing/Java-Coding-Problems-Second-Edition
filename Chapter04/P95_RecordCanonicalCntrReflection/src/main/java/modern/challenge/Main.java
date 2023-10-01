package modern.challenge;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class Main {

    public static void main(String[] args) 
            throws NoSuchMethodException, InvocationTargetException, 
            InstantiationException, IllegalArgumentException, IllegalAccessException {
        
        System.out.println(Records.getCanonicalConstructor(MelonRecord.class));
        System.out.println(Records.getCanonicalConstructor(MelonMarketRecord.class));
        
        Constructor<MelonRecord> cmr = Records.getCanonicalConstructor(MelonRecord.class);
        MelonRecord m1 = cmr.newInstance("Gac", 5000f);
        MelonRecord m2 = cmr.newInstance("Hemi", 1400f);
        
        Constructor<MelonMarketRecord> cmmr = Records.getCanonicalConstructor(MelonMarketRecord.class);
        MelonMarketRecord mm = cmmr.newInstance(List.of(m1, m2), "China");
        
        System.out.println(mm);
    }
}
