import java.security.SecureRandom;

public class Consumer implements Runnable {
    private static final SecureRandom generator = new SecureRandom();
    private final Buffer sharedBuffer;

    public Consumer(Buffer sharedBuffer) {
        this.sharedBuffer = sharedBuffer;
    }

    @Override
    public void run() {
        try {
            sharedBuffer.blockingGet();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    } // end run method

} // end Consumer class


