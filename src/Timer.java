public class Timer {
    private long start;

    public void start() {
        start = System.nanoTime();
    }

    public long stop() {
        long stop = System.nanoTime();
        return stop - start;
    }
}