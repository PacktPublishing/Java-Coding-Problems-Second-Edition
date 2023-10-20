package modern.challenge;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.LockSupport;

public class Main {

    public static void main(String[] args) {       
       
        // CREATING PLATFORM THREADS
        // ATTENTION, THIS CODE MAY SIMPLY HANG ON OR GENERATE AN ERROR: OutOfMemoryError 
        /*
        AtomicLong counterOSThreads = new AtomicLong();
        while (true) {
            Thread.ofPlatform().start(() -> {
                long currentOSThreadNr = counterOSThreads.incrementAndGet();
                System.out.println("Thread: " + currentOSThreadNr);                
                LockSupport.park();                
            });
        } 
        */
        
        /*
        AtomicLong counterOSThreads = new AtomicLong();
        while (true) {
            new Thread(() -> {
                long currentOSThreadNr = counterOSThreads.incrementAndGet();
                System.out.println("Thread: " + currentOSThreadNr);                
                LockSupport.park();                
            }).start();
        }
        */
             
        // CREATING VIRTUAL  THREADS
        // ATTENTION, THIS CODE MAY RUN FOR A LONG TIME (MORE THAN 10 MILLIONS VIRTUAL THREADS) 
        AtomicLong counterOSThreads = new AtomicLong();
        while (true) {
            Thread.startVirtualThread(() -> {
                long currentOSThreadNr = counterOSThreads.incrementAndGet();
                System.out.println("Virtual thread: " + currentOSThreadNr);                
                LockSupport.park();                
            });
        }
    }
}