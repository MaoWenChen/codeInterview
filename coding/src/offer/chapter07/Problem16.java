package offer.chapter07;

/**
 * 寻找矩阵中的路径
 */
public class Problem16 {

    public static boolean solution(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || matrix.length != rows * cols || str == null || str.length < 1) {
            return false;
        }
        boolean[] visted = new boolean[matrix.length];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++) {
                if (helper(matrix, rows, cols, i, j, visted, str, 0)) {
                    return true;
                }
            }
        return false;
    }

    public static boolean helper(char[] matrix, int rows, int cols, int row, int col, boolean[] visted, char[] str, int k) {
        if (k == str.length) {
            return true;
        }
        boolean hasPath = false;
        if (row < rows && row >= 0 && col >= 0 && col < cols
                && visted[row * cols + col] == false
                && matrix[row * cols + col] == str[k]) {
            visted[(row - 1) * cols + col] = true;
            hasPath = helper(matrix, rows, cols, row + 1, col, visted, str, k + 1)
                    || helper(matrix, rows, cols, row, col + 1, visted, str, k + 1)
                    || helper(matrix, rows, cols, row - 1, col, visted, str, k + 1)
                    || helper(matrix, rows, cols, row, col - 1, visted, str, k + 1);
            visted[(row - 1) * cols + col] = false;
        }

        return hasPath;
    }
}
