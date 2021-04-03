package multyTrading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class WithExecutor {
    public static void executorPoolCallableExample () throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(15);
        Callable<String> callable = () -> "Thread inner string = " + Thread.currentThread().getName();
        List<Future<String>> futures = new ArrayList<>();

        for (int i = 0; i < 100; i++)
        {
            futures.add(executor.submit(callable));
        }

        for (Future<String> future : futures)
        {
            System.out.println(future.get());
        }

        executor.shutdown();
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        executorPoolCallableExample();
    }
}
