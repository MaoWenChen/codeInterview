package algorithm.math;

import java.math.BigDecimal;

/**
 * 大数阶层
 * 
 * @author mchen
 *
 */
public class Factorial {
	public static void main(String[] args) {
		System.out.println(test1(18));
		
		System.out.println(test(18));
	}

	// 一般阶层
	public static long test(long n) {
		if (n == 1 || n == 0) {
			return 1;
		}
		return n * test(n - 1);
	}

	// 大数阶层
	public static String test1(int n) {
		int[] res = new int[10000];
		int m = 0;
		res[0] = 1;
		int c = 0;
		for (int i = 2; i <= n; i++) {
			int tmp = 0;
			for (int j = 0; j <= m; j++) {
				tmp = i * res[j] + tmp;
				res[j] = tmp % 10000;
				tmp = tmp / 10000;
			}
			if (tmp > 0) {
				m++;
				res[m] = tmp;
			}
		}
		StringBuffer sf = new StringBuffer();
		sf.append(res[m]);
		for (int j = m-1; j >= 0; j--) {
			sf.append(String.format("%04d",res[j]));
		}
		return sf.toString();
	}
}
