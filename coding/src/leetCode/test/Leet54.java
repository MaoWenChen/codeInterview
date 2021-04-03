package leetCode.test;

import java.util.ArrayList;
import java.util.List;

public class Leet54 {

	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 1 } };
		System.out.println(spiralOrder(matrix));
	}

	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new ArrayList<Integer>();
		if (matrix.length==0) {
			return list;
		}
		int i = 0, j = 0;
		int rowLen = matrix.length-1;
		int colLen = matrix[0].length-1;
		while (rowLen >=i || colLen >= j ) {
			for (int k = j; k <= colLen&&i<=rowLen; k++) {
				list.add(matrix[i][k]);
			}
			i++;
			for (int k = i; k <= rowLen&&j<=colLen; k++) {
				list.add(matrix[k][colLen]);
			}
			colLen--;
			for (int k = colLen; k >= j&&i<=rowLen; k--) {
				list.add(matrix[rowLen][k]);
			}
			rowLen--;
			for (int k = rowLen; k >= i&&j<=colLen; k--) {
				list.add(matrix[k][j]);
			}
			j++;
		}
		return list;
	}

}
