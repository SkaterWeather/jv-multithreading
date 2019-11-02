public class Resource {
    private volatile int counter;
    private String lastModified;

    public Resource() {
        counter = 0;
    }

    public void incrementCounter(String lastModified) {
        this.lastModified = lastModified;
        this.counter++;
        System.out.println(counter + " by " + lastModified);
    }

    public int getCounter() {
        return counter;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }
}
