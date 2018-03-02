package producerandcomsumer.makecake;

public class Test {
    public static void main(String[] args) {
        Table table = new Table(3);
        new Thread(new ConsumerThread(table,1231)).start();
        new Thread(new ConsumerThread(table,1289)).start();
        new Thread(new ConsumerThread(table,1289)).start();
        new Thread(new MakerThread(table,235)).start();
        new Thread(new MakerThread(table,335)).start();
        new Thread(new MakerThread(table,289)).start();
    }
}
