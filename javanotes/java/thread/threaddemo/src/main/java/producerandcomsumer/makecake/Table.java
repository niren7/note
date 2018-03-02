package producerandcomsumer.makecake;

//可以通过继承阻塞队列接口下的实现类来简化Channel角色的构建
public class Table {
    private final String[] buffer;
    private int count;
    private int head;
    private int tail;
    public Table(int count) {
        buffer = new String[count];
        this.count = 0;
        this.head = 0;
        this.tail = 0;
    }
    public synchronized void put(String cake) throws InterruptedException {
        while (count >= buffer.length) {
            wait();
        }
        System.out.println(Thread.currentThread().getName() + " put " + cake);
        buffer[tail] = cake;
        tail = (tail + 1) % buffer.length;
        count++;
        notifyAll();
    }
    public synchronized String take() throws InterruptedException {
        while (count <= 0) {
            wait();
        }
        String cake = buffer[head];
        System.out.println("    " + Thread.currentThread().getName() + " take " + cake);
        head = (head + 1) % buffer.length;
        count--;
        notifyAll();
        return cake;
    }
}
