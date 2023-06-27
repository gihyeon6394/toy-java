package other;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadEx01 {


    public static void main(String[] args) {
        int upper = Integer.parseInt(args[0]);
        ExecutorService pool = Executors.newSingleThreadExecutor();
        Future<Integer> result = pool.submit(new Summation(upper));
        try {
            System.out.println(result.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static class Summation implements Callable<Integer> {
        private int upper;

        public Summation(int upper) {
            this.upper = upper;
        }

        @Override
        public Integer call() throws Exception {
            int sum = 0;
            for (int i = 0; i <= upper; i++) {
                sum += i;
            }
            return new Integer(sum);
        }
    }
}
