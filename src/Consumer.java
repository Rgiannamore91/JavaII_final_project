import java.security.SecureRandom;

public class Consumer implements Runnable {
    private final Buffer sharedBuffer;
    private static final SecureRandom generator = new SecureRandom();

    public Consumer(Buffer sharedBuffer) {
        this.sharedBuffer = sharedBuffer;
    }

    // Search for the values and store the values in the sharedBuffer
    @Override
    public void run() {
        String word = null;
             // sleep 0 to 3 seconds, read value from buffer and add to sum
             try {
                Thread.sleep(generator.nextInt(3000));
                word += sharedBuffer.blockingGet();
               }
             catch (InterruptedException exception) {
                 Thread.currentThread().interrupt();
                 }
             }
 }


