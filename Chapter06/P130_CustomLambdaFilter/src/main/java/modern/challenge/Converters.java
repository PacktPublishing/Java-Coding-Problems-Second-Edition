package modern.challenge;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputFilter.Status;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public final class Converters {

    private Converters() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static byte[] objectToBytes(Serializable obj) throws IOException {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try ( ObjectOutputStream ois = new ObjectOutputStream(baos)) {
            ois.writeObject(obj);
        }

        baos.close();

        return baos.toByteArray();
    }

    public static Object bytesToObject(byte[] bytes)
            throws IOException, ClassNotFoundException {

        try ( InputStream is = new ByteArrayInputStream(bytes);  
                ObjectInputStream ois = new ObjectInputStream(is)) {

            // set the filter via a lambda expression
            ois.setObjectInputFilter(info -> ((info.serialClass() != null)
                    // or, info.serialClass().getName().equals("modern.challenge.Melon")
                    && info.serialClass().getPackage().getName().equals("modern.challenge")
                    && info.serialClass().getSimpleName().equals("Melon"))
                    ? Status.REJECTED : Status.UNDECIDED);

            return ois.readObject();
        }
    }
}
