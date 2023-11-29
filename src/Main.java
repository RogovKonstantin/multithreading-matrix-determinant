import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = generateMatrix(Integer.parseInt(scanner.nextLine()),false);
        MatrixDeterminantOneThread.oneThread(matrix);
        MatrixDeterminantMultipleThreads.multipleThreads(matrix);
    }

    public static int[][] generateMatrix(int n, boolean identicalValues) {
        int[][] matrix = new int[n][n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!identicalValues) {
                    matrix[i][j] = random.nextInt(21) - 10;
                } else {
                    matrix[i][j] = 1;
                }
            }
        }
        printMatrix(matrix);
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int number : ints) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }
}