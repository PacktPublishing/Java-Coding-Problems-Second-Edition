package modern.challenge;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

public final class InstantStopwatch {

    private Instant startTime;
    private Instant stopTime;
    private boolean running;

    public void start() {
        this.startTime = Instant.now();
        this.running = true;
    }

    public void stop() {
        this.stopTime = Instant.now();
        this.running = false;
    }

    //elaspsed time in nanoseconds
    public long getElapsedTime() {
                
        if (running) {
            return ChronoUnit.NANOS.between(startTime, Instant.now());            
        } else {
            return ChronoUnit.NANOS.between(startTime, stopTime);            
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