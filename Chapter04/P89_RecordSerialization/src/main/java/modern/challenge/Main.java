package modern.challenge;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        MelonContainer gacContainer = new MelonContainer(
                LocalDate.now().plusDays(15), "ML9000SQA0", new Melon("Gac", 5000)
        );

        try ( ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("object.data"))) {
            oos.writeObject(gacContainer);
        }

        MelonContainer desGacContainer;
        try ( ObjectInputStream ios = new ObjectInputStream(
                new FileInputStream("object.data"))) {
            desGacContainer = (MelonContainer) ios.readObject();
        }

        System.out.println(desGacContainer);
        
        MelonContainer maliciousDesGacContainer;
        try ( ObjectInputStream ios = new ObjectInputStream(
                new FileInputStream("object_malicious.data"))) {
            maliciousDesGacContainer = (MelonContainer) ios.readObject();
        }

        System.out.println(maliciousDesGacContainer);

        System.out.println();

        MelonContainerRecord gacContainerR = new MelonContainerRecord(
                LocalDate.now().plusDays(15), "ML9000SQA0", new Melon("Gac", 5000)
        );

        try ( ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("object_record.data"))) {
            oos.writeObject(gacContainerR);
        }

        MelonContainerRecord desGacContainerR;
        try ( ObjectInputStream ios = new ObjectInputStream(
                new FileInputStream("object_record.data"))) {
            desGacContainerR = (MelonContainerRecord) ios.readObject();
        }

        System.out.println(desGacContainerR);
        
        /* this will cause the exception of malicious data
        MelonContainerRecord maliciousDesGacContainerR;
        try ( ObjectInputStream ios = new ObjectInputStream(
                new FileInputStream("object_record_malicious.data"))) {
            maliciousDesGacContainerR = (MelonContainerRecord) ios.readObject();
        }

        System.out.println(maliciousDesGacContainerR);
        */
    }
}
