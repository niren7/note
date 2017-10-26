package futuredemo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Test {
    public static void main(String[] args){
        ExecutorService executor = Executors.newCachedThreadPool();
        Task task = new Task();
        FutureTask<String> futureTask = new FutureTask<String>(task);
        executor.submit(task);
        executor.shutdown();
        System.out.println("--------主线程运行开始---------");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("--------主线程运行结束---------");
        try {
            System.out.println("task"+futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("end");

    }
}
