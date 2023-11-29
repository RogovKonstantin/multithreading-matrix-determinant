import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class MatrixDeterminantMultipleThreads {
    static Timer timer = new Timer();

    public static void multipleThreads(int[][] matrix) {
        timer.start();
        ForkJoinPool pool = new ForkJoinPool();
        System.out.println("Результат многопоточного выполнения: " + pool.invoke(new DeterminantComputation(matrix)) + ", за " + timer.stop() + " мс.");
    }

    static class DeterminantComputation extends RecursiveTask<Integer> {
        private final int[][] matrix;

        DeterminantComputation(int[][] matrix) {
            this.matrix = matrix;
        }

        @Override
        protected Integer compute() {
            int n = matrix.length;
            if (n <= 2) {
                return MatrixDeterminantOneThread.computeDeterminant(matrix);
            }

            List<DeterminantComputation> tasks = new ArrayList<>();
            int determinant = 0;
            for (int i = 0; i < n; i++) {
                int[][] minor = new int[n - 1][n - 1];
                for (int j = 1; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if (k < i) {
                            minor[j - 1][k] = matrix[j][k];
                        } else if (k > i) {
                            minor[j - 1][k - 1] = matrix[j][k];
                        }
                    }
                }
                DeterminantComputation task = new DeterminantComputation(minor);
                tasks.add(task);
                task.fork();
            }

            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    determinant += matrix[0][i] * tasks.get(i).join();
                } else {
                    determinant += -1 * matrix[0][i] * tasks.get(i).join();
                }
            }
            return determinant;
        }
    }
}