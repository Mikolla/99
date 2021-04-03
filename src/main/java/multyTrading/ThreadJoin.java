package multyTrading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreadJoin extends Thread {
    private Thread thread;

    public ThreadJoin(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(  thread.getName() + " - wait for next thread "  + currentThread().getName()+ " - continued");
    }

    public static void main(String[] args) {
        Thread main = currentThread();
        List<Thread> threads = new ArrayList<>();
        int i = 0;
        Thread threadToConstructor = main;
        while (i < 200)
        {
            threadToConstructor = new ThreadJoin(threadToConstructor);
            i++;
            threadToConstructor.setName("t" + i);
            threads.add(threadToConstructor);
        }
        Collections.shuffle(threads);
        threads.forEach(x -> System.out.print(x.getName() + " "));
        System.out.println();
        threads.stream().forEach(tr -> tr.start());
    }
}