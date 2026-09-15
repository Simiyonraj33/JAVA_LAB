import java.util.*;   // For Scanner and Arrays.sort()

public class MatrixSorting {

    // Method to print the matrix
    public static void printMatrix(int[][] m) {
        for (int[] row : m) {          // Loop through each row
            for (int val : row) {      // Loop through each element
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    // Method to sort rows (Row-wise sorting)
    public static void sortRows(int[][] m) {

        // Each row is a 1D array → can be sorted directly
        for (int i = 0; i < m.length; i++) {
            Arrays.sort(m[i]);        // Sorting each row
        }
    }

    // Method to sort columns (Column-wise sorting)
    public static void sortColumns(int[][] m) {

        int rows = m.length;
        int cols = m[0].length;

        // Sorting each column separately
        for (int col = 0; col < cols; col++) {

            int[] temp = new int[rows];    // Temporary array to store column values

            // Copy column into temp array
            for (int row = 0; row < rows; row++) {
                temp[row] = m[row][col];
            }

            Arrays.sort(temp);             // Sort the column values

            // Store sorted values back into matrix
            for (int row = 0; row < rows; row++) {
                m[row][col] = temp[row];
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Accept matrix size
        System.out.print("Enter number of rows: ");
        int r = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int c = sc.nextInt();

        int[][] mat = new int[r][c];

        // Accept matrix elements from user
        System.out.println("Enter matrix elements:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                mat[i][j] = sc.nextInt();
