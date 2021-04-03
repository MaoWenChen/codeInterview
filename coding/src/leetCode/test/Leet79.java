package leetCode.test;

public class Leet79 {
	
	public static void main(String[] args) {
		Leet79 leet = new Leet79();
		char[][] c = new char[][] {{'a'}};
		System.out.println(leet.exist(c, "a"));
	}
	private int[] dx = new int[] { 0, 0, 1, -1 };
	private int[] dy = new int[] { 1, -1, 0, 0 };

	public boolean exist(char[][] board, String word) {
		if (word.length()==0) {
			return true;
		}
		boolean[][] vis = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
					if (dfs(i, j, board, vis, word.toCharArray(), 0)) {
						return true;
					}
			}
		}
		return false;
	}

	public boolean dfs(int i, int j, char[][] board, boolean[][] vis, char[] word, int cur) {
		if (cur == word.length) {
			return true;
		} else {
			for (int t = 0; t < dx.length; t++) {
				if (check(i, j, board.length, board[0].length) && board[i][j] == word[cur]&&!vis[i][j]) {
					vis[i][j] = true;
					if (dfs(i+dx[t], j+dy[t], board, vis, word, cur+1)) {
						return true;
					}
					vis[i][j] = false;
				}
			}
			return false;
		}
	}

	public boolean check(int i, int j, int n, int m) {
		if (i<0||i>=n||j<0||j>=m) {
			return false;
		}
		return true;
	}
}
