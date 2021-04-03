package leetCode.test;

public class Leet37 {


	public void solveSudoku(char[][] board) {
		int[][] vrow = new int[9][9];
		int[][] vcol = new int[9][9];
		int[][][] vis3 = new int[3][3][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					continue;
				}
				int num = board[i][j] - '0' - 1;
				vrow[i][num] = 1;
				vcol[j][num] = 1;
				int dX = i / 3;
				int dY = j / 3;
				vis3[dX][dY][num] = 1;
			}
		}
		dfs(vrow, vcol, vis3, 0, 0, board);

	}

	public boolean dfs(int[][] vrow, int[][] vcol, int[][][] vis3, int row, int col, char[][] board) {
		if (row == 9) {
			return true;
		} else {
			if (col == 9) {
				return dfs(vrow, vcol, vis3, row + 1, 0, board);
			}else if(board[row][col]!='.'){
				return dfs(vrow, vcol, vis3, row, col+1, board);
			} else {
				for (int i = 0; i < 9; i++) {
					int dx = row/3;
					int dy = col/3;
					if (vrow[row][i]==0&&vcol[col][i]==0&&vis3[dx][dy][i]==0) {
						vrow[row][i]=1;
						vcol[col][i]=1;
						vis3[dx][dy][i]=1;
						board[row][col] = (char) (i+'0'+1);
						if(!dfs(vrow, vcol, vis3, row, col+1, board)) {
							vrow[row][i]=0;
							vcol[col][i]=0;
							vis3[dx][dy][i]=0;
							board[row][col] = '.';
						}else {
							return true;
						}
					}
				}
				return false;
			}
		}
	}

}
