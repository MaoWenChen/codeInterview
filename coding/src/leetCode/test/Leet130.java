package leetCode.test;

public class Leet130 {

	int[] dx = new int[] { -1, 0, 1, 0 };
	int[] dy = new int[] { 0, 1, 0, -1 };

	// 超时算法
	public void solve(char[][] board) {
		if (board.length == 0)
			return;
		boolean[][] check = new boolean[board.length][board[0].length];
		for (int i = 1; i < board.length - 1; i++) {
			for (int j = 1; j < board[i].length - 1; j++) {
				if (board[i][j] == 'O') {
					check[i][j] = true;
					if (isInclud(i, j, board, check)) {
						board[i][j] = 'X';
					}
					check[i][j] = false;
				}
			}
		}
	}

	public void solve1(char[][] board) {
		if (board.length == 0) {
			return;
		}
		boolean[][] check = new boolean[board.length][board[0].length];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if ((i == 0 || j == 0 || i == board.length - 1 || j == board[i].length - 1) && board[i][j] == 'O'
						&& !check[i][j]) {
					dfs(i, j, board, check);
				}
			}
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (!check[i][j]) {
					board[i][j] = 'X';
				}
			}
		}

	}

	public void dfs(int row, int col, char[][] board, boolean[][] check) {
		if (row >= 0 && row < board.length && col >= 0 && col < board[0].length && board[row][col] == 'O'
				&& check[row][col] == false) {
			check[row][col] = true;
			for (int i = 0; i < dx.length; i++) {
				int newRow = row + dx[i];
				int newCol = col + dy[i];
				dfs(newRow, newCol, board, check);
			}
		}

	}

	public boolean isInclud(int row, int col, char[][] board, boolean[][] check) {
		if (row == 0 || col == 0 || row == board.length - 1 || col == board[0].length - 1) {
			return false;
		} else {
			for (int i = 0; i < 4; i++) {
				int newRow = row + dx[i];
				int newCol = col + dy[i];
				if (!check[newRow][newCol] && board[newRow][newCol] == 'O') {
					check[newRow][newCol] = true;
					if (!isInclud(newRow, newCol, board, check)) {
						check[newRow][newCol] = false;
						return false;
					}
					check[newRow][newCol] = false;

				}
			}
			return true;
		}
	}

}
