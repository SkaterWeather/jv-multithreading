import java.util.List;
import java.util.concurrent.RecursiveTask;

public class RecursiveSumTask extends RecursiveTask<Integer> {
    private List<Integer> list;
    private Integer sum;

    public RecursiveSumTask(List<Integer> list) {
        this.list = list;
        this.sum = 0;
    }

    @Override
    protected Integer compute() {
        list.forEach(i -> sum += i);
        return sum;
    }
}
