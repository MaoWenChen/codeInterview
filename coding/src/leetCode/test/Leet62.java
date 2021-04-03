package leetCode.test;

public class Leet62 {

	public static void main(String[] args) {
		System.out.println(uniquePaths(7, 3));
	}

	public static int uniquePaths(int m, int n) {
		m--;
		n--;
		int tmp = m + n;
		long sum = 1;
		for (int i = tmp; i > n; i--) {
			sum *= i;
			while (m>1&&sum / m > 0 && sum % m == 0) {
				sum /= m;
				m--;
			}
		}
		
		return (int) sum;

	}

}
