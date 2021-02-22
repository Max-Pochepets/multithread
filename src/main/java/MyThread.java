import org.apache.log4j.Logger;

public class MyThread extends Thread {
    public static final int MAX_COUNT = 100;
    private static final Logger logger = Logger.getLogger(MyThread.class);
    private Counter counter;

    public MyThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
            logger.info("MyThread thread started...\n");
            while (counter.getCounter() < MAX_COUNT) {
                logger.info(Thread.currentThread().getName() + " value = "
                        + counter.getCounter() + "\n");
                counter.increment();
            }
            logger.info("My thread finished.\n");
    }
}
