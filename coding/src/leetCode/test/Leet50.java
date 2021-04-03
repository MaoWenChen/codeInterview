package leetCode.test;

public class Leet50 {

	public static void main(String[] args) {
		System.out.println(pow1(2, 10));
	}

	// 超时代码
	public double myPow(double x, int n) {
		if (n == 0 || x == 1) {
			return 1;
		} else if (n == 1) {
			return x;
		} else if (n < 0) {
			return 1 / x * myPow(1 / x, Math.abs(n + 1));
		} else {
			double res = 1;
			while (n > 0) {
				long j = 1;
				double tmp = x;
				while ((j << 1) <= n) {
					tmp *= tmp;
					j <<= 1;
				}
				res *= tmp;
				n -= j;
			}
			return res;
		}
	}

	// 通过代码
	public double myPow1(double x, int n) {
		return ((n % 2 == 0) ? 1 : ((n % 2 == 1) ? x : 1 / x)) * ((n % 2 == n) ? 1 : myPow(x * x, n / 2));
	}

	public static int pow1(int x, int n) {
		if (x == 1 || n == 0) {
			return 1;
		}

		int flag = 1;
		int res = 1;

		for (int i = 0; i < 31 && n >= flag; i++) {
			if ((flag & n) != 0) {
				res *= x;
			}
			x *= x;
			flag <<= 1;
		}
		return res;
	}

	public double myPow2(double x, int n) {
		return ((n % 2 == 0) ? 1 : ((n % 2 == 1) ? x : 1 / x)) * ((n % 2 == n) ? 1 : myPow(x * x, n / 2));
	}

}
