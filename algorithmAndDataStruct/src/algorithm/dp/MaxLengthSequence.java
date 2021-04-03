package algorithm.dp;

/**
 * 最长上升子序列
 * 
 * @author mchen
 *
 */
public class MaxLengthSequence {

	private static final int LEN = Integer.MAX_VALUE;
	private static int[] a = new int[LEN];
	private static int[] maxLen = new int[LEN];// 记忆中间结构
	static {
		for (int i = 0; i < LEN; i++) {
			maxLen[i] = -1;
		}
	}

	// 递归获取最长上升子序列长度
	public static int maxLen(int i) {
		if (i == 0) {
			return 1;
		}
		int max = 0;
		for (int j = i - 1; j >= 0; j++) {
			if (a[i] >= a[j]) {
				max = Math.max(max, 1 + maxLen(j));
			}
		}
		return max;
	}

	// 记忆化的递归
	public static int maxLenMember(int i) {
		if (maxLen[i] != -1) {
			return maxLen[i];
		}
		if (i == 0) {
			maxLen[i] = 1;
		} else {
			int max = 1;
			for (int j = i - 1; j >= 0; j++) {
				if (a[i] >= a[j]) {
					max = Math.max(max, 1 + maxLenMember(j));
				}
			}
			maxLen[i] = max;
		}
		return maxLen[i];
	}

	// 递推函数
	public static int maxLenPush(int i) {
		int[] dp = new int[LEN];
		dp[0] = 1;
		for (int k = 1; k < LEN; k++) {
			int max = 1;
			for (int t = k - 1; t >= 0; t--) {
				if (a[k] >= a[t]) {
					max = Math.max(max, dp[t] + 1);
				}
			}
			dp[k] = max;
		}
		return dp[LEN - 1];
	}

	// 优化时间复杂度O(nlogn)递推加二分查找
	/**
	 * 这次用len来表示当前上升子序列的长度，d数组来存放对应LIS长度的最小末尾。
	 * 
	 * 例如：A = {1 5 3 4 7}，那么d[1] = 1,d[2] = 3,d[3] = 4, d[4] =
	 * 7。（其中d[1]LIS长度为1，d[3]LIS长度为3，以此类推）
	 */
	public static int maxOptizime(int i) {
		int[] d = new int[LEN];
		d[0] = a[0];
		int len = 1;
		for (int k = 1; k < LEN; k++) {
			if (a[k]>=d[len-1]) {
				d[len++] = a[k];
			}else {
				int index = binarySearch(d, 0, len-1, a[k]);
				d[index] = a[k];
			}
		}
		return len;
	}

	public static int binarySearch(int[] arr, int start, int end, int num) {
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] >= num) {
				return mid;
			} else {
				start = mid + 1;
			}
		}
		return start;
	}
}
