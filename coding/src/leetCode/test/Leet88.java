package leetCode.test;

public class Leet88 {

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m-1;
		int j = n-1;
		int index = nums1.length-1;
		while (i >=0 || j>=0) {
			int tmp1 = i>=0?nums1[i]:Integer.MIN_VALUE;
			int tmp2 = j>=0?nums2[j]:Integer.MIN_VALUE;
			nums1[index--] = Math.max(tmp1, tmp2);
			if (tmp1<tmp2) {
				j--;
			}else {
				i--;
			}
		}
	}
}
