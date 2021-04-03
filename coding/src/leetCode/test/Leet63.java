package leetCode.test;

public class Leet63 {
	public static void main(String[] args) {
		int[][] area = new int[][] {{0,0,0},{0,1,0},{0,0,0}};
		System.out.println(uniquePathsWithObstacles(area));
	}
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int[] dp = new int[obstacleGrid.length+1];
		dp[1] = 1;
		for (int i = 0; i < obstacleGrid.length; i++) {
			for (int j = 0; j < obstacleGrid[i].length; j++) {
				if (obstacleGrid[i][j]!=0) {
					dp[j+1] = 0;
				}else {
					dp[j+1] = dp[j]+dp[j+1];
				}
			}
		}
		return dp[obstacleGrid.length];
	}

}
