import java.security.SecureRandom;

public class Consumer implements Runnable {
    private final Buffer sharedBuffer;
    private static final SecureRandom generator = new SecureRandom();

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
    }

} // end Consumer class


