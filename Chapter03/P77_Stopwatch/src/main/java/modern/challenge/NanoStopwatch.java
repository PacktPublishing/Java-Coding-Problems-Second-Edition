package modern.challenge;

import java.util.concurrent.TimeUnit;

public final class NanoStopwatch {

    private long startTime;
    private long stopTime;
    private boolean running;

    public void start() {
        this.startTime = System.nanoTime();
        this.running = true;
    }

    public void stop() {
        this.stopTime = System.nanoTime();
        this.running = false;
    }

    //elaspsed time in nanoseconds
    public long getElapsedTime() {
                
        if (running) {
            return System.nanoTime() - startTime;
        } else {
            return stopTime - startTime;            
        }        
    }
    
    //elaspsed time in millisecods
    public long elapsedTimeToMillis(long nanotime) {                
        
        return TimeUnit.MILLISECONDS.convert(nanotime, TimeUnit.NANOSECONDS);
    }
    
    //elaspsed time in seconds
    public long elapsedTimeToSeconds(long nanotime) {                
        
        return TimeUnit.SECONDS.convert(nanotime, TimeUnit.NANOSECONDS);
    }
}