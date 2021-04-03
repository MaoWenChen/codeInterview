package leetCode.test;

public class Leet52 {

	int sum = 0;

	public int totalNQueens(int n) {

		boolean[][] area = new boolean[n][n];
		boolean[] vis = new boolean[n];
		int[] rowCol = new int[n];
		dfs(0, area, vis, rowCol);
		return sum;
		
	}

	public void dfs(int cur ,boolean[][] area,boolean[]  vis,int[] rowCol) {
		if(cur == vis.length) {
			sum++;
		}else {
			for(int i = 0;i<vis.length;i++) {
				if (check(cur, i, vis, rowCol)) {
					vis[i] = true;
					rowCol[cur] = i;
					dfs(cur+1, area, vis, rowCol);
					vis[i] = false;
					rowCol[cur] = 0;
				}
			}
			
		}
		
	}
	public boolean check(int row, int col,boolean[] vis,int[] rowCol) {
		if (vis[col]) {
			return false;
		}
		for(int i = row-1;i>=0;i--) {
			if (Math.abs(row-i)==Math.abs(col-rowCol[i])) {
				return false;
			}
		}
		return true;
	}

}
