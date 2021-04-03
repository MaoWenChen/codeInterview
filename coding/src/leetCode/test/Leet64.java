package leetCode.test;

public class Leet64 {
	public static void main(String[] args) {
		int[][] grid = new int[][] {{1,3,1},{1,5,1},{4,2,1}};
		System.out.println(minPathSum(grid));
	}

	public static int minPathSum(int[][] grid) {
		int[] dp = new int[grid[0].length + 1];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (i == 0 ) {
					dp[j+1] = dp[j]+grid[i][j];
				}else if(j==0) {
					dp[j+1] = dp[j + 1] + grid[i][j];
				}else {
					dp[j + 1] = Math.min(dp[j], dp[j + 1]) + grid[i][j];
				}
			}
		}
		return dp[grid[0].length];
	}
}
