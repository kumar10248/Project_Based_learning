
public class PascalTriangle {
    public static int[][] pascalTriangle(int N) {

        int[][] result = new int[N][];

        for (int i = 0; i < N; i++) {

            result[i] = new int[i + 1];

            result[i][0] = 1;
            result[i][i] = 1;

            for (int j = 1; j < i; j++) {
                result[i][j] = result[i - 1][j - 1] + result[i - 1][j];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int N = 10;
        int[][] triangle = pascalTriangle(N);
        for (int[] row : triangle) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
