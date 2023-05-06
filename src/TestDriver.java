import javax.swing.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestDriver  {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();


        CircularBuffer sharedBuffer = new CircularBuffer();
        CircularBuffer.SelectionScreen();


        executorService.execute(new Producer(sharedBuffer));
        executorService.execute(new Consumer(sharedBuffer));

        executorService.shutdown();


    } // end method main

} // end class TestDriver