package modern.challenge;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public final class Converters {

    private Converters() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static byte[] objectToBytes(Object obj) throws IOException {

        ByteArrayOutputStream boas = new ByteArrayOutputStream();
        try ( ObjectOutputStream ois = new ObjectOutputStream(boas)) {
            ois.writeObject(obj);
        }

        return boas.toByteArray();
    }

    public static Object bytesToObject(byte[] bytes)
            throws IOException, ClassNotFoundException {
        
        InputStream is = new ByteArrayInputStream(bytes);
        try ( ObjectInputStream ois = new ObjectInputStream(is)) {
            return ois.readObject();
        }
    }
}
