package modern.challenge;

import jnr.ffi.annotations.IgnoreError;

public interface SimpleMath { 
    @IgnoreError
    long sumTwoInt(int x, int y);
}