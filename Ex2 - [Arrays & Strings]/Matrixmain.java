import java.util.Scanner;

// Class containing all matrix-related methods
class MatrixOperations {

    // Method to read a matrix from user
    public static int[][] readMatrix(Scanner sc, String name) {

        // Read rows and columns
        System.out.print("Enter number of rows for " + name + ": ");
        int rows = sc.nextInt();

        System.out.print("Enter number of columns for " + name + ": ");
        int cols = sc.nextInt();

        // Create matrix with given size
        int[][] mat = new int[rows][cols];

        System.out.println("Enter elements of " + name + ":");

        // Accept matrix elements from user
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        return mat;
    }

    // Method for matrix addition
    public static int[][] add(int[][] A, int[][] B) {

        int r = A.length;       // number of rows
        int c = A[0].length;    // number of columns

        int[][] res = new int[r][c];   // result matrix

        // Add corresponding elements
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = A[i][j] + B[i][j];
            }
        }

        return res;
    }

    // Method for matrix multiplication
    public static int[][] multiply(int[][] A, int[][] B) {

        int r1 = A.length;      // rows of A
        int c1 = A[0].length;   // cols of A
        int r2 = B.length;      // rows of B
        int c2 = B[0].length;   // cols of B

        int[][] res = new int[r1][c2];  // result matrix

        // Standard matrix multiplication logic
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                res[i][j] = 0;

                for (int k = 0; k < c1; k++) {
                    res[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return res;
    }

    // Method to find transpose of a matrix
    public static int[][] transpose(int[][] M) {

        int r = M.length;       // rows
        int c = M[0].length;    // columns

        int[][] t = new int[c][r];  // NOTE: rows & columns swapped

        // Swap row index and column index
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                t[i][j] = M[j][i];
            }
        }

        return t;
    }

    // Method to print a matrix
    public static void printMatrix(int[][] M) {

        for (int[] row : M) {         // for each row
            for (int val : row) {     // for each element
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}

// Main class as asked: MatrixMain
public class MatrixMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read two matrices from user
        int[][] A = MatrixOperations.readMatrix(sc, "Matrix A");
        int[][] B = MatrixOperations.readMatrix(sc, "Matrix B");

        int choice;

        // Menu-driven program
        do {
            System.out.println("\n--- MATRIX OPERATIONS MENU ---");
            System.out.println("1. Addition");
            System.out.println("2. Multiplication");
            System.out.println("3. Transpose of Matrix A");
            System.out.println("4. Transpose of Matrix B");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                // Addition option
                case 1:
                    // Valid only if dimensions match
                    if (A.length == B.length && A[0].length == B[0].length) {
                        System.out.println("Result of Addition:");
                        MatrixOperations.printMatrix(MatrixOperations.add(A, B));
                    } else {
                        System.out.println("Addition not possible — matrix sizes must be equal!");
                    }
                    break;

                // Multiplication option
                case 2:
                    // Valid only if A columns = B rows
                    if (A[0].length == B.length) {
                        System.out.println("Result of Multiplication:");
                        MatrixOperations.printMatrix(MatrixOperations.multiply(A, B));
                    } else {
                        System.out.println("Multiplication not possible — columns of A must equal rows of B!");
                    }
                    break;

                // Transpose of A
                case 3:
                    System.out.println("Transpose of Matrix A:");
                    MatrixOperations.printMatrix(MatrixOperations.transpose(A));
                    break;

                // Transpose of B
                case 4:
                    System.out.println("Transpose of Matrix B:");
                    MatrixOperations.printMatrix(MatrixOperations.transpose(B));
                    break;

                case 0:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again!");
            }

        } while (choice != 0);
    }
}