import java.security.SecureRandom;

public class Producer implements Runnable {
    private static final SecureRandom generator = new SecureRandom();
    private final Driver sharedBuffer;
    private int value;

    public Producer(Driver sharedBuffer) {
        this.sharedBuffer = sharedBuffer;
    } // constructor


    // store the values in the sharedBuffer
    @Override
    public void run() {
        try {
            sharedBuffer.blockingPut(value);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }


} // end Producer class
