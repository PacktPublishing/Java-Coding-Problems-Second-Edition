package modern.challenge;

import java.util.List;

public class Main {

    public static void main(String[] args) {       

        FiveFunction<Double, Double, Double, Double, Double, Double> pl4 = (a, b, c, d, x)
                -> d + ((a - d) / (1 + (Math.pow(x / c, b))));        

        List<Double> allX = List.of(40.3, 100.0, 250.2, 400.1, 600.6, 800.4, 1150.4, 1400.6);        
        List<Double> allY = Logistics.compute(4.19, -1.10, 12.65, 0.03, allX, pl4);
        
        System.out.println(allY);
        
        PL4 pl4_1 = Logistics.create(4.19, -1.10, 12.65, 0.03, 40.3, PL4::new);
        PL4 pl4_2 = Logistics.create(4.19, -1.10, 12.65, 0.03, 100.0, PL4::new);
        PL4 pl4_3 = Logistics.create(4.19, -1.10, 12.65, 0.03, 250.2, PL4::new);
        PL4 pl4_4 = Logistics.create(4.19, -1.10, 12.65, 0.03, 400.1, PL4::new);
        PL4 pl4_5 = Logistics.create(4.19, -1.10, 12.65, 0.03, 600.6, PL4::new);
        PL4 pl4_6 = Logistics.create(4.19, -1.10, 12.65, 0.03, 800.4, PL4::new);
        PL4 pl4_7 = Logistics.create(4.19, -1.10, 12.65, 0.03, 1150.4, PL4::new);
        PL4 pl4_8 = Logistics.create(4.19, -1.10, 12.65, 0.03, 1400.6, PL4::new);
        
        System.out.println();
        System.out.println(pl4_1.compute());
        System.out.println(pl4_2.compute());
        System.out.println(pl4_3.compute());
        System.out.println(pl4_4.compute());
        System.out.println(pl4_5.compute());
        System.out.println(pl4_6.compute());
        System.out.println(pl4_7.compute());
        System.out.println(pl4_8.compute());
    }
}