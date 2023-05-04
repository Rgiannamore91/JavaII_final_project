import java.util.concurrent.ArrayBlockingQueue;

public class SynchronizedCalendar implements Buffer {
    //private String buffer = null;
    private final ArrayBlockingQueue<String> buffer;


    public SynchronizedCalendar() {
        buffer = new ArrayBlockingQueue<>(30);

    }

    // Producer
    @Override
    public void blockingPut(String value) throws InterruptedException {
        //buffer = value;
        buffer.put(value);
        System.out.printf("%s\t%n", "Producer writes ", value);

    }

// Consumer
    @Override
    public String blockingGet() throws InterruptedException {
        String readValue = buffer.take();
        System.out.printf("%s\t%n", "Consumer reads ", readValue);
        return buffer.take();
    }
}
