package modern.challenge;

import java.util.concurrent.TimeUnit;

public final class MillisStopwatch {

    private long startTime;
    private long stopTime;
    private boolean running;

    public void start() {
        this.startTime = System.currentTimeMillis();
        this.running = true;
    }

    public void stop() {
        this.stopTime = System.currentTimeMillis();
        this.running = false;
    }

    //elaspsed time in nanoseconds
    public long getElapsedTime() {
                
        if (running) {
            return System.currentTimeMillis() - startTime;
        } else {
            return stopTime - startTime;            
        }        
    }
    
    //elaspsed time in millisecods
    public long elapsedTimeToNanos(long millistime) {                
        
        return TimeUnit.NANOSECONDS.convert(millistime, TimeUnit.MILLISECONDS);
    }
    
    //elaspsed time in seconds
    public long elapsedTimeToSeconds(long millistime) {                
        
        return TimeUnit.SECONDS.convert(millistime, TimeUnit.MILLISECONDS);
    }
}