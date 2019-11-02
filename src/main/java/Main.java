public class Main {
    private static final int COUNT_LIMIT = 100;

    public static void main(String[] args) {
        Resource resource = new Resource();
        Thread threadExt = new ThreadExt(resource, COUNT_LIMIT);
        Thread threadRun = new Thread(new ThreadRun(resource, COUNT_LIMIT));

        threadExt.start();
        threadRun.start();
        try {
            threadExt.join();
            threadRun.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(resource.getLastModified() + " has WON!");
    }
}
