package leetCode.test;

import java.util.ArrayList;
import java.util.List;

public class Leet119 {
	public static void main(String[] args) {
		System.out.println(getRow(3));
	}
	public static List<Integer> getRow(int rowIndex) {
		int[] dp = new int[rowIndex+1];
		int[] dp1 = new int[rowIndex+1];
		dp[0] = 1;
		int [] tmp = null;
		for(int i = 1;i<=rowIndex;i++) {
			dp1[0] = 1;
			for(int j = 1;j<=i;j++) {
				dp1[j] = dp[j-1]+dp[j];
			}
			tmp = dp1;
			dp1 = dp;
			dp = tmp;
		}
		List<Integer> list = new ArrayList<Integer>(rowIndex);
		for(int i = 0;i<=rowIndex;i++) {
			list.add(i,dp[i]);
		}
		return list;
		
	}

}
