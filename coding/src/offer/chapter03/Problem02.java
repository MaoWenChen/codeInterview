package offer.chapter03;

/**
 * 顺时针打印矩阵
 */
public class Problem02 {

    public static void solution(int[][] arr, int rows, int cols) {
        if (arr == null || rows <= 0 || cols <= 0) return;
        int start = 0;
        while (cols > 2 * start && rows > 2 * start) {
            printMatrix(arr, rows, cols, start);
            start++;
        }
    }

    private static void printMatrix(int[][] arr, int rows, int cols, int start) {
        for (int i = start; i < cols - start; i++) {
            System.out.println(arr[start][i]);
        }
        for (int i = start + 1; i < rows - start; i--) {
            System.out.println(arr[i][cols - start - 1]);
        }
        for (int i = cols - start - 1; i >= start; i--) {
            System.out.println(arr[rows - start][i]);
        }
        for (int i = rows - start - 1; i > start; i--) {
            System.out.println(arr[i][start]);
        }
    }
}
