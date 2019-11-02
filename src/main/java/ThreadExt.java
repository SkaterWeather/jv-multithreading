public class ThreadExt extends Thread {
    private Resource resource;
    private int countLimit;
    private String threadName;

    public ThreadExt(Resource resource, int countLimit) {
        this.resource = resource;
        this.countLimit = countLimit;
        this.threadName = "ThreadExtended";
    }

    @Override
    public void run() {
        while (resource.getCounter() < countLimit) {
            resource.incrementCounter(threadName);
        }
    }
}
