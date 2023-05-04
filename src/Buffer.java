public interface Buffer {
    public void blockingPut(String value) throws InterruptedException; // Producer
    public String blockingGet() throws InterruptedException; // Consumer
}
