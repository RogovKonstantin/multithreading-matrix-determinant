public class MatrixDeterminantOneThread {
    static Timer timer = new Timer();
    public static void oneThread(int[][] matrix) {
        timer.start();
        System.out.println("Результат однопоточного выполнения: " + computeDeterminant(matrix) + ", за " + timer.stop() + " мс.");
    }

    public static int computeDeterminant(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) {
            return matrix[0][0];
        } else if (n == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

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
            if (i % 2 == 0) {
                determinant += matrix[0][i] * computeDeterminant(minor);
            } else {
                determinant += -1 * matrix[0][i] * computeDeterminant(minor);
            }
        }
        return determinant;
    }
}
