package producerandcomsumer.makecake;

import java.util.Random;

public class ConsumerThread implements Runnable {
    private final Table table;

    private final Random random;

    public ConsumerThread(Table table, long seed) {
        this.table = table;
        this.random = new Random(seed);
    }

    public void run() {
        try {
            while (true) {
                String cake = table.take();
                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
