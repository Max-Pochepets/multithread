import org.apache.log4j.Logger;

public class MyRunnable implements Runnable {
    public static final int MAX_COUNT = 100;
    private static final Logger logger = Logger.getLogger(MyRunnable.class);
    private Counter counter;

    public MyRunnable(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        logger.info("MyRunnable thread started...\n");
        while (counter.getCounter() < MAX_COUNT) {
            logger.info(Thread.currentThread().getName() + " value = "
                    + counter.getCounter() + "\n");
            counter.increment();
        }
        logger.info("MyRunnable finished.\n");
    }
}
