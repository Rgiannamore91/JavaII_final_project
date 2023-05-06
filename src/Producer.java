import java.security.SecureRandom;

public class Producer implements Runnable {
    private final CircularBuffer sharedBuffer;
    private int value;
    private static final SecureRandom generator = new SecureRandom();

    public Producer(CircularBuffer sharedBuffer) {
        this.sharedBuffer = sharedBuffer;
    }



    // Search for the values and store the values in the sharedBuffer
    @Override
    public void run() {
        try {
            sharedBuffer.blockingPut(value);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            //throw new RuntimeException(e);
        }
    }


} // end Producer class
