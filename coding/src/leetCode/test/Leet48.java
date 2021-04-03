package leetCode.test;

public class Leet48 {
	public void rotate(int[][] matrix) {

		for (int i = 0; i < matrix.length; i++) {
			for (int j = i + 1; j < matrix.length; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = tmp;
			}
		}
		for (int i = 0; i < matrix.length / 2; i++) {
			for (int j = 0; j < matrix.length; j++) {
				int tmp = matrix[j][i];
				matrix[j][i] = matrix[j][matrix.length - 1 - i];
				matrix[j][matrix.length - 1 - i] = tmp;
			}
		}

	}

	/**
	 * 对于n * n 的2维矩阵A[i][j]旋转后的位置 -> A[j][n-1-i]
	 * 
	 * 对于90度的翻转有很多方法，一步或多步都可以解，我们先来看一种直接的方法，对于当前位置，
	 * 计算旋转后的新位置，然后再计算下一个新位置，第四个位置又变成当前位置了，所以这个方法每次循环换四个数字，
	 * 
	 */

	public void rotate1(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n / 2; i++) {
			for (int j = i; j < n - 1 - i; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[n - 1 - j][i];
				matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
				matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
				matrix[j][n - 1 - i] = tmp;
			}
		}
	}
}
