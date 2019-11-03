import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class SumByForkJoin {
    private List<Integer> list;
    private int totalSum;
    //means THREAD_LIST_SIZE, i need a short name for that variable
    private final int TLS;
    private final int THREAD_QUANTITY;

    public SumByForkJoin(List<Integer> list, int THREAD_QUANTITY) {
        this.list = list;
        this.THREAD_QUANTITY = THREAD_QUANTITY;
        this.TLS = list.size() / THREAD_QUANTITY;
        this.totalSum = 0;
    }

    public Integer calculateSum() {
        for (int i = 0; i < THREAD_QUANTITY; i++) {
            totalSum += new ForkJoinPool()
                    .invoke(new RecursiveSumTask(list.subList(i * TLS, i * TLS + TLS)));
        }
        return totalSum;
    }
}
