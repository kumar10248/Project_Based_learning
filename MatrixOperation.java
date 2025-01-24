

// Write a Java program to perform matrix operations (addition, subtraction, and multiplication) on two matrices provided by the user. The program should:
//Check the dimensions of the matrices to ensure valid operations.
//Display the result of the operation.
import java.util.Scanner;

public class MatrixOperation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       
            System.out.println("Enter dimensions for first matrix:");
            System.out.print("Rows: ");
            int rows1 = scanner.nextInt();
            System.out.print("Columns: ");
            int cols1 = scanner.nextInt();

            int[][] matrix1 = new int[rows1][cols1];

            System.out.println("Enter the elements of the first matrix:");
            inputMatrix(matrix1, rows1, cols1, scanner);

            System.out.println("Enter dimensions for second matrix:");
            System.out.print("Rows: ");
            int rows2 = scanner.nextInt();
            System.out.print("Columns: ");
            int cols2 = scanner.nextInt();

            int[][] matrix2 = new int[rows2][cols2];

            System.out.println("Enter the elements of the second matrix:");
            inputMatrix(matrix2, rows2, cols2, scanner);

            System.out.println("Choose the operation: 1 for addition, 2 for subtraction, 3 for multiplication");
            int choice = scanner.nextInt();

            int[][] result;

            switch (choice) {
                case 1:
                    if (rows1 != rows2 || cols1 != cols2) {
                        System.out.println("Matrices must have same dimensions for addition");
                        return;
                    }
                    result = addMatrices(matrix1, matrix2, rows1, cols1);
                    System.out.println("Result of addition:");
                    displayMatrix(result, rows1, cols1);
                    break;
                case 2:
                    if (rows1 != rows2 || cols1 != cols2) {
                        System.out.println("Matrices must have same dimensions for subtraction");
                        return;
                    }
                    result = subtractMatrices(matrix1, matrix2, rows1, cols1);
                    System.out.println("Result of subtraction:");
                    displayMatrix(result, rows1, cols1);
                    break;
                case 3:
                    if (cols1 != rows2) {
                        System.out.println("Number of columns in first matrix must equal number of rows in second matrix");
                        return;
                    }
                    result = multiplyMatrices(matrix1, matrix2, rows1, cols2, cols1);
                    System.out.println("Result of multiplication:");
                    displayMatrix(result, rows1, cols2);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
     
    }

    private static void inputMatrix(int[][] matrix, int rows, int cols, Scanner scanner) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2, int rows, int cols) {
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    public static int[][] subtractMatrices(int[][] matrix1, int[][] matrix2, int rows, int cols) {
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }

    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2, int rows1, int cols2, int cols1) {
        int[][] result = new int[rows1][cols2];
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                result[i][j] = 0;
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }

    public static void displayMatrix(int[][] matrix, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}