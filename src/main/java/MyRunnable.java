import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class MyRunnable implements Runnable {
    public static final int MAX_COUNT = 100;
    private static final Logger logger = Logger.getLogger(MyRunnable.class.getSimpleName());
    private Counter counter;

    public MyRunnable(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        try {
            logger.addHandler(new FileHandler("logs/app.log"));
            logger.info("MyRunnable thread started...\n");
            while (counter.getCounter() < MAX_COUNT) {
                logger.info(Thread.currentThread().getName() + " value = "
                        + counter.getCounter() + "\n");
                counter.increment();
            }
            logger.info("MyRunnable finished.\n");
        } catch (IOException e) {
            throw new RuntimeException("Could not add logger handler", e);
        }
    }
}
