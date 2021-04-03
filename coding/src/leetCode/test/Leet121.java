package leetCode.test;

public class Leet121 {
	public int maxProfit(int[] prices) {
		int max = 0;
		if (prices.length==0) {
			return max;
		}
		int pre = prices[0];
		for(int i = 1;i<prices.length;i++) {
			max = Math.max(prices[i]-pre, max);
			pre = Math.min(pre, prices[i]);
		}
		return max;
	}

}
