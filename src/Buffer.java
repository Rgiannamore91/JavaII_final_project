public interface Buffer {
    public void blockingPut(int value) throws InterruptedException; // Producer

    public int blockingGet() throws InterruptedException; // Consumer

} // end Buffer interface
