package leetCode.test;

public class Leet122 {

	public static int maxProfit(int[] prices) {
		int[] dp = new int[prices.length];
		int max = 0;
		int tmp = 0;
		for (int i = 1; i < prices.length; i++) {
			tmp = 0;
			for (int j = i - 1; j >= 0; j--) {
				if (prices[i] - prices[j] + dp[j] > tmp) {
					tmp = prices[i] - prices[j] + dp[j];
				}
			}
			dp[i] = Math.max(tmp, dp[i - 1]);
			max = Math.max(dp[i], max);
		}
		return max;
	}

	// 将每一个上升的段加起来就是最大的利润

	public static int maxPrifox(int[] prices) {
		int maxprofit = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1])
				maxprofit += prices[i] - prices[i - 1];
		}
		return maxprofit;
	}

	public static void main(String[] args) {
		int[] arr = { 7, 1, 5, 3, 6, 4 };
		System.out.println(maxProfit(arr));
	}
}
