package leetCode.test;

public class Leet123 {

	public int maxProfit(int[] prices) {
		if (prices.length == 0 || prices.length == 1) {
			return 0;
		}
		int[] dp = new int[prices.length];
		int min = prices[0];
		int max = prices[prices.length-1];
		int maxValue = 0;
		
		for (int i = 1; i < prices.length; i++) {
			dp[i] = Math.max(dp[i-1], prices[i]- min);
			min = Math.min(min, prices[i]);
		}
		for(int i = prices.length-2;i>=0;i--) {
			dp[i] = Math.max(dp[i], dp[i] + max - prices[i]);
			max =Math.max(prices[i], max);
			maxValue = Math.max(maxValue, dp[i]);
		}
		return maxValue;

	}
}
