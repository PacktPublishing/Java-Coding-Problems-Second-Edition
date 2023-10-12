package modern.challenge;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.Arena;
import java.lang.foreign.ValueLayout;
import java.nio.ByteOrder;
import java.util.Arrays;
import jdk.incubator.vector.DoubleVector;
import jdk.incubator.vector.FloatVector;
import jdk.incubator.vector.IntVector;
import jdk.incubator.vector.Vector;
import jdk.incubator.vector.VectorMask;
import jdk.incubator.vector.VectorOperators;
import jdk.incubator.vector.VectorShape;
import jdk.incubator.vector.VectorShuffle;
import jdk.incubator.vector.VectorSpecies;

public class Main {

    public static void main(String[] args) {

        // examples of creating VectorSpecies
        VectorSpecies<Double> VS1 = VectorSpecies.of(double.class, VectorShape.S_512_BIT);
        VectorSpecies<Double> VS2 = VectorSpecies.of(double.class, VectorShape.S_Max_BIT);
        VectorSpecies<Double> VS3 = VectorSpecies.ofLargestShape(double.class);
        VectorSpecies<Double> VS4 = VectorSpecies.ofPreferred(double.class);
        VectorSpecies<Double> VS5 = DoubleVector.SPECIES_512;
        VectorSpecies<Double> VS6 = DoubleVector.SPECIES_MAX;
        VectorSpecies<Double> VS7 = DoubleVector.SPECIES_PREFERRED;

        // print the element type and shape for VS
        System.out.println("Element type (VS1): " + VS1.elementType());
        System.out.println("Shape (VS1): " + VS1.vectorShape());
        System.out.println("Element type (VS2): " + VS2.elementType());
        System.out.println("Shape (VS2): " + VS2.vectorShape());
        System.out.println("Element type (VS3): " + VS3.elementType());
        System.out.println("Shape (VS3): " + VS3.vectorShape());
        System.out.println("Element type (VS4): " + VS4.elementType());
        System.out.println("Shape (VS4): " + VS4.vectorShape());
        System.out.println("Element type (VS5): " + VS5.elementType());
        System.out.println("Shape (VS5): " + VS5.vectorShape());
        System.out.println("Element type (VS6): " + VS6.elementType());
        System.out.println("Shape (VS6): " + VS6.vectorShape());
        System.out.println("Element type (VS7): " + VS7.elementType());
        System.out.println("Shape (VS7): " + VS7.vectorShape());
        System.out.println();

        // getting length (number of lanes/scalars)
        VectorSpecies<Float> VSF = FloatVector.SPECIES_256;
        System.out.println("Length: " + VSF.length());
        System.out.println("Length: " + VSF.vectorBitSize()/VSF.elementSize());
        System.out.println();
        
        // creating vectors
        VectorSpecies<Integer> VS256 = IntVector.SPECIES_256;
        
        // creating vectors of zeros
        Vector<Integer> v1 = VS256.zero();
        System.out.println("v1: " + Arrays.toString(v1.toIntArray()));
        
        IntVector v2 = IntVector.zero(VS256);
        System.out.println("v2: " + Arrays.toString(v2.toIntArray()));
        
        // creating vectors of same primitive value
        Vector<Integer> v3 = VS256.broadcast(5);
        System.out.println("v3: " + Arrays.toString(v3.toIntArray()));
        
        IntVector v4 = IntVector.broadcast(VS256, 5);
        System.out.println("v4: " + Arrays.toString(v4.toIntArray()));
        
        IntVector v5 = IntVector.broadcast(VS256, 0);
        System.out.println("v5: " + Arrays.toString(v5.toIntArray()));
        
        // fromArray()
        int[] varr1 = new int[] {0, 1, 2, 3, 4, 5, 6, 7};  
        Vector<Integer> vfa1 = VS256.fromArray(varr1, 0);
        System.out.println("vfa1: " + Arrays.toString(vfa1.toIntArray()));
        
        int[] varr2 = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        Vector<Integer> vfa2 = VS256.fromArray(varr2, 0);
        System.out.println("vfa2: " + Arrays.toString(vfa2.toIntArray()));
        
        int[] varr3 = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        Vector<Integer> vfa3 = VS256.fromArray(varr3, 2);
        System.out.println("vfa3: " + Arrays.toString(vfa3.toIntArray()));

        // java.lang.IndexOutOfBoundsException
        // int[] varr4 = new int[]{0, 1, 2, 3, 4, 5};
        // IntVector vfa4 = IntVector.fromArray(VS256, varr4, 0);

        int[] varr5 = new int[] {0, 1, 2, 3, 4, 5, 6, 7};
        IntVector vfa5 = IntVector.fromArray(VS256, varr5, 0);
        System.out.println("vfa5: " + Arrays.toString(vfa5.toIntArray()));
        
        int[] varr6 = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
        boolean[] bm1 = new boolean[]{false, false, true, false, false, true, true, false};        
        VectorMask m1 = VectorMask.fromArray(VS256, bm1, 0);
        IntVector vfa6 = IntVector.fromArray(VS256, varr6, 0, m1);
        System.out.println("vfa6: " + Arrays.toString(vfa6.toIntArray()));

        int[] varr7 = new int[]{11, 12, 15, 17, 20, 22, 29};
        int[] imap1 = new int[]{0, 0, 0, 1, 1, 6, 6, 6};
        IntVector vfa7 = IntVector.fromArray(VS256, varr7, 0, imap1, 0);
        System.out.println("vfa7: " + Arrays.toString(vfa7.toIntArray()));

        int[] varr8 = new int[]{11, 12, 15, 17, 20, 22, 29};
        boolean[] bm2 = new boolean[]{false, false, true, false, false, true, true, false};
        int[] imap2 = new int[]{0, 0, 0, 1, 1, 6, 6, 6};        
        VectorMask m2 = VectorMask.fromArray(VS256, bm2, 0);
        IntVector vfa8 = IntVector.fromArray(VS256, varr8, 0, imap2, 0, m2);
        System.out.println("vfa8: " + Arrays.toString(vfa8.toIntArray()));
        
        // fromMemorySegment()
        IntVector vfms;
        MemorySegment segment;
        try (Arena arena = Arena.ofConfined()) {
 
            segment = arena.allocate(32);
            segment.setAtIndex(ValueLayout.JAVA_INT, 0, 11);
            segment.setAtIndex(ValueLayout.JAVA_INT, 1, 21);
            segment.setAtIndex(ValueLayout.JAVA_INT, 2, 12);
            segment.setAtIndex(ValueLayout.JAVA_INT, 3, 7);
            segment.setAtIndex(ValueLayout.JAVA_INT, 4, 33);
            segment.setAtIndex(ValueLayout.JAVA_INT, 5, 1);
            segment.setAtIndex(ValueLayout.JAVA_INT, 6, 3);
            segment.setAtIndex(ValueLayout.JAVA_INT, 7, 6);
            
            vfms = IntVector.fromMemorySegment(VS256, segment, 0, ByteOrder.nativeOrder());
        }

        System.out.println("vfms: " + Arrays.toString(vfms.toIntArray()));
                        
        // slice
        int[] v = new int[] {10, 11, 12, 13, 14, 15, 16, 17};  
        Vector<Integer> vo = VS256.fromArray(v, 0);
        Vector<Integer> vs = vo.slice(vo.length()/2);
        System.out.println("Original vector: " + Arrays.toString(vo.toIntArray()));
        System.out.println("Sliced vector: " + Arrays.toString(vs.toIntArray()));
        
        // unslice
        Vector<Integer> vus = vs.unslice(4, vo, 0);
        System.out.println("Unsliced vector: " + Arrays.toString(vus.toIntArray()));        
              
        // shuffle
        VectorShuffle<Integer> shuffle = VectorShuffle
                .fromArray(VS256, new int[] {2, 1, 3, 0, 6, 7, 5, 4}, 0);
        Vector<Integer> vi = vo.rearrange(shuffle);
        System.out.println("Shuffled vector: " + Arrays.toString(vi.toIntArray()));        
        
        // expand and compress
        VectorMask vm = VectorMask.fromArray(VS256, new boolean[]{false, false, true, false, false, true, true, false}, 0);
        Vector<Integer> ve = vo.expand(vm);
        Vector<Integer> vc = vo.compress(vm);
        System.out.println("Expanded vector: " + Arrays.toString(ve.toIntArray()));        
        System.out.println("Compressed vector: " + Arrays.toString(vc.toIntArray()));        
                
        // cast shape
        VectorSpecies<Integer> VS512cast = IntVector.SPECIES_512;
        VectorSpecies<Integer> VS256cast = IntVector.SPECIES_256;
        VectorSpecies<Integer> VS128cast = IntVector.SPECIES_128;
        IntVector vs1cast = IntVector.fromArray(VS256cast, new int[] {0, 1, 2, 3, 4, 5, 6, 7}, 0);
        Vector<Integer> vs0cast = vs1cast.castShape(VS512cast, 0);
        Vector<Integer> vs2cast = vs1cast.castShape(VS128cast, 0);
        System.out.println("vs0cast: " + Arrays.toString(vs0cast.toIntArray()));        
        System.out.println("vs1cast: " + Arrays.toString(vs1cast.toIntArray()));        
        System.out.println("vs2cast: " + Arrays.toString(vs2cast.toIntArray()));        
        
        // convert element type        
        FloatVector vsfloat = FloatVector.fromArray(FloatVector.SPECIES_256, 
                new float[] {0.5f, 1.4f, 2.2f, 3.7f, 4.3f, 5.7f, 6.7f, 7.7f}, 0);
        Vector<Integer> vsint = vsfloat.convert(VectorOperators.Conversion.ofCast(float.class, int.class), 0);
        System.out.println("vsfloat: " + vsfloat);        
        System.out.println("vsint: " + vsint);        
                
        // convert shape and element type
        FloatVector vsfloat256 = FloatVector.fromArray(FloatVector.SPECIES_256, 
                new float[] {0.5f, 1.4f, 2.2f, 3.7f, 4.3f, 5.7f, 6.7f, 7.7f}, 0);
        Vector<Integer> vsint128 = vsfloat256.convertShape(
                VectorOperators.Conversion.ofCast(float.class, int.class), IntVector.SPECIES_128, 0);
        System.out.println("vsfloat: " + vsfloat256);        
        System.out.println("vsint: " + vsint128);   
        
        // reinterpret shape
        FloatVector vsfloatb = FloatVector.fromArray(FloatVector.SPECIES_256, 
                new float[] {0.5f, 1.4f, 2.2f, 3.7f, 4.3f, 5.7f, 6.7f, 7.7f}, 0);
        Vector<Float> vsfloata = vsfloatb.reinterpretShape(FloatVector.SPECIES_512, 0);
        System.out.println("vsfloatb: " + vsfloatb);        
        System.out.println("vsfloata: " + vsfloata);        
    }
}