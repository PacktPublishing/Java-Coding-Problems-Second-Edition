package modern.challenge;

import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    private static final ScopedValue<String> SCOPED_VALUE_1 = ScopedValue.newInstance();
    private static final ScopedValue<String> SCOPED_VALUE_2 = ScopedValue.newInstance();
    private static final ScopedValue<String> SCOPED_VALUE_3 = ScopedValue.newInstance();

    public static void main(String[] args) throws InterruptedException, Exception {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        // chaining where() calls
        Runnable task = () -> {
            logger.info(Thread.currentThread().toString());
            logger.info(() -> SCOPED_VALUE_1.isBound() ? SCOPED_VALUE_1.get() : "Not bound");
            logger.info(() -> SCOPED_VALUE_2.isBound() ? SCOPED_VALUE_2.get() : "Not bound");
            logger.info(() -> SCOPED_VALUE_3.isBound() ? SCOPED_VALUE_3.get() : "Not bound");
        };

        ScopedValue.where(SCOPED_VALUE_1, "Kaboooom - 1").run(task);

        ScopedValue.where(SCOPED_VALUE_1, "Kaboooom - 1")
                .where(SCOPED_VALUE_2, "Kaboooom - 2")
                .run(task);

        ScopedValue.where(SCOPED_VALUE_1, "Kaboooom - 1")
                .where(SCOPED_VALUE_2, "Kaboooom - 2")
                .where(SCOPED_VALUE_3, "Kaboooom - 3")
                .run(task);
        logger.info("-------------------------------------");

        // rebind
        Runnable taskB = () -> {
            logger.info(() -> "taskB: " + Thread.currentThread().toString());
            logger.info(() -> SCOPED_VALUE_1.isBound() ? SCOPED_VALUE_1.get() : "Not bound");
            logger.info(() -> SCOPED_VALUE_2.isBound() ? SCOPED_VALUE_2.get() : "Not bound");
            logger.info(() -> SCOPED_VALUE_3.isBound() ? SCOPED_VALUE_3.get() : "Not bound");
        };

        Runnable taskA = () -> {
            logger.info(() -> "taskA: " + Thread.currentThread().toString());
            logger.info(() -> SCOPED_VALUE_1.isBound() ? SCOPED_VALUE_1.get() : "Not bound");
            ScopedValue.where(SCOPED_VALUE_1, "No kaboooom") // rebind
                    .where(SCOPED_VALUE_2, "Kaboooom - 2")
                    .where(SCOPED_VALUE_3, "Kaboooom - 3")
                    .run(taskB);
            logger.info(() -> SCOPED_VALUE_1.isBound() ? SCOPED_VALUE_1.get() : "Not bound");
            logger.info(() -> SCOPED_VALUE_2.isBound() ? SCOPED_VALUE_2.get() : "Not bound");
            logger.info(() -> SCOPED_VALUE_3.isBound() ? SCOPED_VALUE_3.get() : "Not bound");
        };

        ScopedValue.where(SCOPED_VALUE_1, "Kaboooom - 1").run(taskA);
    }
}