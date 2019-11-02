public class ThreadRun implements Runnable {
    private Resource resource;
    private int countLimit;
    private String threadName;

    public ThreadRun(Resource resource, int countLimit) {
        this.resource = resource;
        this.countLimit = countLimit;
        this.threadName = "ThreadRunnable";
    }

    public void run() {
        while (resource.getCounter() < countLimit) {
            resource.incrementCounter(threadName);
        }
    }
}
