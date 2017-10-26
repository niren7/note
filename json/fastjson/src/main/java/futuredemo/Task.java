package futuredemo;

import java.util.concurrent.Callable;

public class Task implements Callable {

    @Override
    public String call(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "result";
    }
}
