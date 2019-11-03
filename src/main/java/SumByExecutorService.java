import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SumByExecutorService {
    private List<Integer> list;
    private int totalSum;
    //means THREAD_LIST_SIZE, i need a short name for that variable
    private final int TLS;
    private final int THREAD_QUANTITY;

    public SumByExecutorService(List<Integer> list, int THREAD_QUANTITY) {
        this.list = list;
        this.THREAD_QUANTITY = THREAD_QUANTITY;
        this.TLS = list.size() / THREAD_QUANTITY;
        this.totalSum = 0;
    }

    public Integer calculateSum() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_QUANTITY);
        Callable<Integer>[] threads = new Callable[THREAD_QUANTITY];
        Future<Integer>[] sums = new Future[THREAD_QUANTITY];

        for (int i = 0; i < THREAD_QUANTITY; i++) {
            threads[i] = new ThreadCallable(list.subList(i * TLS, i * TLS + TLS));
            sums[i] = executorService.submit(threads[i]);
        }

        executorService.shutdown();
        for (Future<Integer> future : sums) {
            totalSum += future.get();
        }
        return totalSum;
    }
}
