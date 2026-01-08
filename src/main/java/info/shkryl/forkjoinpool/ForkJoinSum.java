package info.shkryl.forkjoinpool;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinSum extends RecursiveTask<Long> {

    private static final long THRESHOLD = 10_000; // Порог для разделения
    private final long[] numbers;
    private final int start;
    private final int end;

    public ForkJoinSum(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    private ForkJoinSum(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        // Если задача мала — считаем напрямую
        if (end - start <= THRESHOLD) {
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += numbers[i];
            }
            return sum;
        }

        // Иначе — делим пополам
        int mid = start + (end - start) / 2;
        ForkJoinSum leftTask = new ForkJoinSum(numbers, start, mid);
        ForkJoinSum rightTask = new ForkJoinSum(numbers, mid, end);

        // Асинхронно запускаем левую задачу
        leftTask.fork();
        // Текущий поток обрабатывает правую
        Long rightResult = rightTask.compute();
        // Ждём результат левой
        Long leftResult = leftTask.join();

        return leftResult + rightResult;
    }

    public static void main(String[] args) {
        long[] numbers = new long[10_000_000];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i;
        }

        ForkJoinPool pool = new ForkJoinPool();
        long sum = pool.invoke(new ForkJoinSum(numbers));
        System.out.println("Sum: " + sum); // Должно быть 49999995000000

        pool.shutdown();
    }
}
