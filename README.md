# Matrix Determinant Calculator
This Java project provides functionality for calculating the determinant of a square matrix using both single-threaded and multi-threaded approaches. The main class Main generates a random square matrix of a specified size and then computes its determinant using both methods.

# Matrix Generation
The generateMatrix(int n, boolean identicalValues) method in the Main class generates an n x n square matrix with random integer values. If identicalValues is set to true, the matrix is filled with a constant value of 1.

# Single-Threaded Determinant Calculation
The MatrixDeterminantOneThread class contains a method oneThread(int[][] matrix) that computes the determinant of a given matrix using a single-threaded algorithm. The algorithm uses recursion to calculate the determinant of submatrices and sums the results to obtain the final determinant.

# Multi-Threaded Determinant Calculation
The MatrixDeterminantMultipleThreads class uses the Fork-Join framework to compute the determinant of a matrix using multiple threads. It defines a DeterminantComputation task that recursively splits the matrix into submatrices, computes their determinants in parallel, and combines the results to obtain the final determinant.
