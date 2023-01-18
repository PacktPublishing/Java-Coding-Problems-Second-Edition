package modern.challenge;

import java.util.Objects;

public final class NumberConverter {
    
    private NumberConverter() {
        throw new AssertionError("Cannot be instantiated");
    }
    
    public static int toLeIntV1(byte[] arr, int offset) {

        if (offset < 0
                || Integer.BYTES < 0 // not necessary
                || arr.length < 0    // not necessary
                || (offset + Integer.BYTES) > arr.length) {
            throw new IndexOutOfBoundsException();
        }

        int leint = arr[offset + 3];
        for (int i = 2; i >= 0; i--) {
            leint = (leint << 8) | (arr[offset + i] & 0xff);
        }
        return leint;
    }

    public static int toLeIntV2(byte[] arr, int offset) {

        Objects.checkFromIndexSize(offset, Integer.BYTES, arr.length);

        int leint = arr[offset + 3];
        for (int i = 2; i >= 0; i--) {
            leint = (leint << 8) | (arr[offset + i] & 0xff);
        }
        return leint;
    }
}
