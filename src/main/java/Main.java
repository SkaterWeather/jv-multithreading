import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Main {
    private static final int LIST_SIZE = 1_000_000;
    private static List<Integer> list;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        list = generateArray();

        SumByExecutorService sumByExecutorService = new SumByExecutorService(list, 10);
        System.out.println("Sum By Executor Service: " + sumByExecutorService.calculateSum());

        SumByForkJoin sumByForkJoin = new SumByForkJoin(list, 10);
        System.out.println("Sum By Fork Join: " + sumByForkJoin.calculateSum());
    }

    private static ArrayList<Integer> generateArray() {
        ArrayList<Integer> list = new ArrayList<>(LIST_SIZE);
        int min = 1, max = 10;
        for (int i = 0; i < LIST_SIZE; i++) {
            list.add((int) (Math.random() * ((max - min) + 1)) + min);
        }
        return list;
    }
}
