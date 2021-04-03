package offer.chapter01;

/**
 * 二维数组中查找一个数
 */
public class Problem02 {
    /**
     * 数组每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     */
    public static boolean solution(int[][] matrix, int num) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = 0;
        int col = matrix[0].length - 1;
        boolean find = false;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == num) {
                find = true;
                break;
            } else if (matrix[row][col] > num) {
                row++;
            } else {
                col--;
            }
        }
        return find;
    }
}
