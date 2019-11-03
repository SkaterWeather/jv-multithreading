import java.util.List;
import java.util.concurrent.Callable;

public class ThreadCallable implements Callable<Integer> {
    private List<Integer> list;
    private Integer sum;

    public ThreadCallable(List<Integer> list) {
        this.list = list;
        this.sum = 0;
    }

    @Override
    public Integer call() {
        list.forEach(i -> sum += i);
        return sum;
    }
}
