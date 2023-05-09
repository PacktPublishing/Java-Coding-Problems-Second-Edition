package modern.challenge;

public class Main {

    public static void main(String[] args) {    
                
        FiveConsumer<Double, Double, Double, Double, Double> pl4c = (a, b, c, d, x) ->
                Logistics.pl4(a, b, c, d, x);
        
        pl4c.accept(4.19, -1.10, 12.65, 0.03, 40.3);        
    }
}