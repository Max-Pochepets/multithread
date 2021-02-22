import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class MyThread extends Thread {
    public static final int MAX_COUNT = 100;
    private static final Logger logger = Logger.getLogger(MyThread.class.getSimpleName());
    private Counter counter;

    public MyThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        try {
            logger.addHandler(new FileHandler("logs/app.log"));
            logger.info("MyThread thread started...\n");
            while (counter.getCounter() < MAX_COUNT) {
                logger.info(Thread.currentThread().getName() + " value = "
                        + counter.getCounter() + "\n");
                counter.increment();
            }
            logger.info("My thread finished.\n");
        } catch (IOException e) {
            throw new RuntimeException("Could not add logger handler", e);
        }
    }
}
