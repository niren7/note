package producerandcomsumer.makecake;

import java.util.Random;

public class MakerThread implements Runnable {

    private final Random random;

    private final Table table;

    private static int id = 0; //所有maker共用

    public MakerThread(Table table, long seed) {
        this.table = table;
        this.random = new Random(seed);
    }

    private static synchronized int nextId() {
        return id++;
    }

    public void run() {
        try {
            while (true) {
                Thread.sleep(random.nextInt(1000));
                String cake = "Cake No." + nextId();
                table.put(cake);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
