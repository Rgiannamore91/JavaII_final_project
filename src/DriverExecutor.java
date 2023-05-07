/**
 * DriverExecutor.java - Advanced Topics used to create a Month's Calendar
 * CMSY 167 Spring 2023
 *
 * @author Ryan Giannamore, Rissah Remy
 * @version 1.0
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Displays the dates and days of a Calendar
  */
public class DriverExecutor {
    public static void main(String[] args) throws InterruptedException {
        // create new thread pool
        ExecutorService executorService = Executors.newCachedThreadPool();

        Gui sharedBuffer = new Gui();
        Gui.SelectionScreen();

        // execute the Producer and Consumer
        executorService.execute(new Producer(sharedBuffer));
        executorService.execute(new Consumer(sharedBuffer));

        executorService.shutdown();

    } // end method main

} // end class TestDriver