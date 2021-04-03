package leetCode.test;

public class Leet115 {
	
	public static void main(String[] args) {
		String s = "rabbbit";
		String t = "rabbit";
		System.out.println(numDistinct1(s,t));
	}
	//超时算法
	public int numDistinct(String s, String t) {
		if (t.length()== 0) {
			return 1;
		}else if(s.length()==0||s.length()<t.length()){
			return 0;
		}else {
			int left = 0;
			int right = 0;
			if (s.charAt(0)==t.charAt(0)) {
				left = numDistinct(s.substring(1), t.substring(1));
			}
			right = numDistinct(s.substring(1), t);
			return left + right;
		}
	}
	//动态规划
	public static int numDistinct1(String s, String t) {
		int[][] dp = new int[t.length()+1][s.length()+1];
		dp[0][0] = 1;
		for(int i =0 ;i<t.length();i++) {
			for(int j = i;j<s.length();j++) {
				if (s.charAt(j)==t.charAt(i)) {
					int tmp = 0;
					for(int k=j;k>=0;k--) {
						tmp +=dp[i][k];
					}
					dp[i+1][j+1]=tmp;
				}
				
			}
		}
		int tmp = 0;
		for(int i = 0;i<s.length();i++) {
			tmp +=dp[t.length()][i+1];
		}
		return tmp;
	}
	//空间复杂度O(n)
	 public static int numDistinct2(String s, String t) {
	        int n = s.length();
	        int m = t.length();
	        int[] dp = new int[m];
	        for(int i = 0; i < n; i++){
	            int prev = 1;
	            for(int j = 0; j < m; j++){
	                int temp = dp[j];
	                if(s.charAt(i) == t.charAt(j)){
	                    dp[j] += prev;
	                }
	                prev = temp;
	            }
	        }
	        
	        return dp[m-1];
	    }
}
