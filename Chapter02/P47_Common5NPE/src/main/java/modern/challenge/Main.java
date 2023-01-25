package modern.challenge;

public class Main {

    public static void main(String[] args) {

        // 1 - NPE when calling an instance method via a null object
        ChainSaw cs = ChainSaw.initChainSaw("QW-T650"); // 'cs' is null
        cs.start();
        
        // 2 - NPE when accessing (or, modifying) field of a null object
        // ChainSaw cs = ChainSaw.initChainSaw("QW-T650"); // 'cs' is null
        // boolean isStarted = cs.started;
        
        // 3 - NPE when null is passed in method argument
        // ChainSaw cs = ChainSaw.initChainSaw(null); // the passed null can be the result of calling an external service
        
        // 4 - NPE when accessing index value of null array (or, collection)
        /*
        ChainSaw myChainSaw = ChainSaw.initChainSaw("QWE-T800");

        ChainSaw[] friendsChainSaw = new ChainSaw[]{
            ChainSaw.initChainSaw("Q22-T450"),
            ChainSaw.initChainSaw("QRT-T300"),
            ChainSaw.initChainSaw("Q-T900"),
            null, // ops!
            ChainSaw.initChainSaw("QMM-T850"), // this model is not supported
            ChainSaw.initChainSaw("ASR-T900")
        };
        
        int score = myChainSaw.performance(friendsChainSaw);
        */
        
        // 5 - NPE when accessing a field via a getter
        // ChainSaw cs = ChainSaw.initChainSaw("T5A-T800");
        // String power = cs.getPower();
        // System.out.println(power.concat(" Watts"));
    }
}
