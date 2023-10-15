package modern.challenge;

import com.sun.jna.Library;

public interface SimpleMath extends Library { 
    long sumTwoInt(int x, int y);
}