package algorithm.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 方盒游戏｛N个方盒摆成一排，每个方盒有自己的颜色，连续相同的颜色构成一个块，每点击一个方块，则块消失，如果消失了k个方法，则得k*k分，求可获得的最大积分｝
 */
public class Square {
	// 递归
	public static int dfs(int[] color, int[] len, int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return len[0];
		}
		int max = 0;
		for (int i = 0; i < n; i++) {
			int tmp = len[i];
			int[] tmpColor = merge(color, i + 1, i - 1);
			boolean flag = tmpColor.length < color.length - 1 ? true : false;
			int[] tmpLen = mergeLen(len, i + 1, i - 1, flag);
			max = Math.max(max, dfs(tmpColor, tmpLen, flag ? n - 2 : n - 1));
		}
		return max;
	}

	public static int[] mergeLen(int[] arr, int start, int end, boolean flag) {
		int[] len;
		int index;
		if (flag) {
			len = new int[arr.length - 2];
			index = start + 1;
		} else {
			len = new int[arr.length - 1];
			index = start;
		}
		for (int i = 0; i <= end; i++) {
			len[i] = arr[i];
		}
		if (flag) {
			len[end] += arr[start];
		}
		int i = end + 1;
		while (index < arr.length) {
			len[i] = arr[index++];
		}
		return len;
	}

	public static int[] merge(int[] arr, int start, int end) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i <= end; i++) {
			list.add(arr[i]);
		}
		if (!list.isEmpty() && start < arr.length) {
			int tmp = arr[end];
			if (tmp == arr[start]) {
				list.remove(list.size() - 1);
			}
			list.add(arr[start]);
		}
		for (int i = start + 1; i < arr.length; i++) {
			list.add(arr[i]);
		}
		int[] res = new int[list.size()];
		for (int i = 0; i < res.length; i++) {
			res[i] = list.get(i);
		}
		return res;
	}

	// 记忆化递归
	private static int[][][] score;
	/*
	 * 大块j的右边已经有一个长度为ex_len的大块(该大块可能是在合 并过程中形成的，不妨就称其为ex_len)， 且j的颜色和ex_len 相同，
	 * 在此情况下将 i 到j以及ex_len都消除所能得到的最高分。于是整个问题就是求：click_box(0,n-1,0)
	 */

	public static int maxSorce(int i, int j, int ex_Len, int[] color, int[] len) {
		if (score[i][j][ex_Len] != -1) {
			return score[i][j][ex_Len];
		}
		int result = (len[j] + ex_Len) ^ 2;
		if (i == j) {
			return result;
		}
		result += maxSorce(i, j - 1, 0, color, len);
		for (int k = i; k < j; k++) {
			if (color[k]==color[j]) {
				int r = maxSorce(k+1, j-1, 0, color, len);
				r += maxSorce(i, k, ex_Len+len[j], color, len);
				result = Math.max(result, r);
			}
		}
		score[i][j][ex_Len] = result;
		return result;
	}
}
