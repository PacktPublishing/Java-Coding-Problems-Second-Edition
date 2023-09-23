package modern.challenge;

public class Main {

    public static void main(String[] args) throws InterruptedException {

       InstantStopwatch is = new InstantStopwatch();
       is.start();
       
       Thread.sleep(1000); // sleep 1s
       
       long betais = is.getElapsedTime();
       
       Thread.sleep(2000); // sleep 2s
       
       is.stop();
       
       long alfais = is.getElapsedTime();

       System.out.println(betais + " nano");
       System.out.println(is.elapsedTimeToMillis(betais) + " millis");
       System.out.println(is.elapsedTimeToSeconds(betais) + " seconds");                  
       
       System.out.println();
       
       System.out.println(alfais + " nano");
       System.out.println(is.elapsedTimeToMillis(alfais) + " millis");
       System.out.println(is.elapsedTimeToSeconds(alfais) + " seconds");                  
       
       System.out.println("\n--------------------------------------------------\n");
               
       MillisStopwatch ms = new MillisStopwatch();
       ms.start();
       
       Thread.sleep(1000); // sleep 1s
       
       long betams = ms.getElapsedTime();
       
       Thread.sleep(2000); // sleep 2s
       
       ms.stop();
       
       long alfams = ms.getElapsedTime();

       System.out.println(betams + " millis");
       System.out.println(ms.elapsedTimeToNanos(betams) + " nanos");
       System.out.println(ms.elapsedTimeToSeconds(betams) + " seconds");                  
                   
       System.out.println();
       
       System.out.println(alfams + " millis");
       System.out.println(ms.elapsedTimeToNanos(alfams) + " nanos");
       System.out.println(ms.elapsedTimeToSeconds(alfams) + " seconds");                     
      
       System.out.println("\n--------------------------------------------------\n");
       
       NanoStopwatch ns = new NanoStopwatch();
       ns.start();
       
       Thread.sleep(1000); // sleep 1s
       
       long betans = ns.getElapsedTime();
       
       Thread.sleep(2000); // sleep 2s
       
       ns.stop();
       
       long alfans = ns.getElapsedTime();

       System.out.println(betans + " nano");
       System.out.println(ns.elapsedTimeToMillis(betans) + " millis");
       System.out.println(ns.elapsedTimeToSeconds(betans) + " seconds");                  
       
       System.out.println();
       
       System.out.println(alfans + " nano");
       System.out.println(ns.elapsedTimeToMillis(alfans) + " millis");
       System.out.println(ns.elapsedTimeToSeconds(alfans) + " seconds");                                
    }
}