package leetCode.test;

import java.util.ArrayList;
import java.util.List;

public class Leet89 {

	public static void main(String[] args) {

			System.out.println(grayCode(1));
	}
	public static List<Integer> grayCode(int n) {
		int len = (int) Math.pow(2, n);
        List<Integer> ans = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            ans.add(i ^ (i >> 1));
        }
        return ans;
		
	}
}
