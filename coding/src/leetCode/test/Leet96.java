package leetCode.test;

public class Leet96 {

	public static void main(String[] args) {
		System.out.println(numTrees(2));
	}
	
	public static int numTrees(int n) {
		
		int[][] dp = new int[n+1][n+1];
		for(int i = 0;i<=n;i++) {
			for(int j = 0;j<=i;j++)
			dp[i][j] = 1;
		}
		for(int t = 2;t<=n;t++)
			for(int i = 1;i<=n-t+1;i++) {
				int j = i+t-1;
				int sum = dp[i][j-1];
				for(int k = i;k<j;k++) {
					sum +=dp[i][k-1]*dp[k+1][j];
				}
				dp[i][j] = sum;
			}
		return dp[1][n];
	}
}
