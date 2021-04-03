package leetCode.test;

import java.util.HashSet;
import java.util.Set;

public class Leet60 {
	public static void main(String[] args) {
		System.out.println(getPermutation(4, 9));
	}

	public static String getPermutation(int n, int k) {
		StringBuilder sb = new StringBuilder();
		int[] pow = new int[n + 1];
		pow[0] = 1;
		for (int i = 1; i <= n; i++) {
			pow[i] = pow[i - 1] * i;
		}
		Set<Integer> set = new HashSet<Integer>();
		int num = n;
		while (n>0) {
			for (int i = 1; i <= num; i++) {
				if (!set.contains(i)&&pow[n-1]<k) {
					k -= pow[n-1];
				}else if(!set.contains(i)&&pow[n-1]>=k) {
					sb.append(i);
					set.add(i);
					n--;
					break;
				}
			}
		}
		return sb.toString();

	}

}
