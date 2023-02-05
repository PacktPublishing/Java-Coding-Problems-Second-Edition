package modern.challenge;

public class Main {

    public static void main(String[] args) throws InterruptedException {

       NanoStopwatch ns = new NanoStopwatch();
       ns.start();
       
       Thread.sleep(1000); // sleep 1s
       
       long beta = ns.getElapsedTime();
       
       Thread.sleep(2000); // sleep 2s
       
       ns.stop();
       
       long alfa = ns.getElapsedTime();

       System.out.println(beta + " nano");
       System.out.println(ns.elapsedTimeToMillis(beta) + " millis");
       System.out.println(ns.elapsedTimeToSeconds(beta) + " seconds");                  
                   
       System.out.println();
       
       System.out.println(alfa + " nano");
       System.out.println(ns.elapsedTimeToMillis(alfa) + " millis");
       System.out.println(ns.elapsedTimeToSeconds(alfa) + " seconds");       
              
    }
}
