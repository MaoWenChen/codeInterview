package leetCode.test;

public class Leet70 {
	//递归
	public int climbStairs(int n) {
		if(n<=1) {
			return 1;
		}
		return climbStairs(n-1)+climbStairs(n-2);
	}
	//dp
	public int climbStairs1(int n) {
		int f1 = 1;
		int f2 = 1;
		for(int i = 2;i<=n;i++) {
			int tmp = f2;
			f2 = f1+f2;
			f1 = tmp;
		}
		return f2;
	}
}
