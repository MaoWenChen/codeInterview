package leetCode.test;

import java.util.ArrayList;
import java.util.List;

public class Leet51 {
	
	public static void main(String[] args) {
		System.out.println(new Leet51().solveNQueens(4));
	}

	List<List<String>> list = new ArrayList<List<String>>();

	public List<List<String>> solveNQueens(int n) {
		char[][] res = new char[n][n];
		int[] visRow = new int[n];
		for(int i = 0;i<res.length;i++) {
			for(int j = 0;j<res[i].length;j++) {
				res[i][j] = '.';
			}
		}
		boolean[] visCol = new boolean[n];
		
		dfs(0, res, visCol, visRow);
		return list;
	}

	public void dfs(int row, char[][] res, boolean[] visCol, int[] visRow) {
		if (row == res.length) {
			List<String> tmp = new ArrayList<>();
			for (char[] c : res) {
				tmp.add(String.valueOf(c));
			}
			list.add(tmp);
		} else {
			for (int i = 0; i < visCol.length; i++) {
				if (check(row, i, visCol, visRow)) {
					res[row][i]= 'Q';
					visRow[row] = i;
					visCol[i] = true;
					dfs(row+1, res, visCol, visRow);
					visCol[i] = false;
					visRow[row] = 0;
				}
				res[row][i] = '.';
			}
		}
	}
	public boolean check(int row, int col, boolean[] visCol, int[] visRow) {
		if (visCol[col]) {
			return false;
		}
		for(int i = 0;i<row;i++) {
			if (Math.abs(col-visRow[i])==Math.abs(row-i)) {
				return false;
			}
			
		}
		return true;
	}
}
