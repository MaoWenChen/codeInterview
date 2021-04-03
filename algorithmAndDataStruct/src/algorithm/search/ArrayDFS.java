package algorithm.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayDFS {

	public static void main(String[] args) {
		int[] arr = new int[] {2,3,1,1,4};
		System.out.println(jump(arr));
	}

	public static int jump(int[] A) {
		if (A == null) {
			return 0;
		}
		int tmp[] = new int[A.length];
		for (int i = A.length - 2; i >= 0; i--) {
			if (A[i] + i >= A.length-1) {
				tmp[i] = 1;
			} else {
				int min = Integer.MAX_VALUE-1;
				for (int j = 1; j <= A[i]; j++) {
					if (tmp[i + j] + 1 < min) {
						min = tmp[i + j] + 1;
					}
				}
				tmp[i] = min;
			}
		}
		return tmp[0];

	}

	private static ArrayList<ArrayList<Integer>> lists = null;

	public static ArrayList<ArrayList<Integer>> permute(int[] num) {
		if (num == null) {
			return lists;
		}
		lists = new ArrayList<>();
		dfs1(0, num, new ArrayList<>());
		return lists;

	}

	public static void dfs1(int cur, int[] num, ArrayList<Integer> list) {
		if (cur == num.length) {
			lists.add((ArrayList<Integer>) list.clone());
		} else {
			for (int i = 0; i < num.length; i++) {
				if (!list.contains(num[i])) {
					list.add(num[i]);
					dfs1(cur + 1, num, list);
					list.remove(list.size() - 1);
				}
			}
		}
	}

	public static ArrayList<ArrayList<Integer>> permuteUnique2(int[] num) {
		lists = new ArrayList<>();
		if (num == null) {
			return lists;
		}
		Arrays.sort(num);
		pdfs(num, 0, new boolean[num.length], new ArrayList<>());
		return lists;
	}

	public static void pdfs(int[] num, int cur, boolean[] uesed, ArrayList<Integer> list) {
		if (cur == num.length) {
			lists.add((ArrayList<Integer>) list.clone());
		} else {
			for (int i = 0; i < num.length; i++) {
				if (uesed[i]) {
					continue;
				}
				if (i > 0 && num[i] == num[i - 1] && !uesed[i - 1]) {
					continue;
				}
				uesed[i] = true;
				list.add(num[i]);
				pdfs(num, cur + 1, uesed, list);
				list.remove(list.size() - 1);
				uesed[i] = false;

			}
		}

	}

	public static ArrayList<ArrayList<Integer>> permuteUnique1(int[] num) {
		ArrayList<ArrayList<Integer>>[] tmp = new ArrayList[2];
		tmp[0] = new ArrayList<>();
		tmp[1] = new ArrayList<>();
		ArrayList<Integer> array = new ArrayList<>();
		array.add(num[0]);
		tmp[0].add(array);
		int k = 0;
		for (int i = 1; i < num.length; i++) {
			for (ArrayList<Integer> list : tmp[k]) {
				for (int j = list.size(); j >= 0; j--) {
					ArrayList<Integer> tmpList = (ArrayList<Integer>) list.clone();
					tmpList.add(j, num[i]);
					if (!tmp[k ^ 1].contains(tmpList)) {
						tmp[k ^ 1].add(tmpList);
					}
				}
			}
			tmp[k].clear();
			k = k ^ 1;
		}
		return tmp[k];
	}

	public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		lists = new ArrayList<>();
		if (num == null) {
			return lists;
		}
		Arrays.sort(num);
		dfs(0, num);
		return lists;
	}

	public static void dfs(int cur, int[] num) {
		if (cur == num.length) {
			ArrayList<Integer> list = new ArrayList<>();
			for (int i : num) {
				list.add(i);
			}
			lists.add(list);
		} else {
			for (int i = cur; i < num.length; i++) {
				if (i == cur || (i != cur && num[cur] != num[i])) {
					int tmp = num[cur];
					num[cur] = num[i];
					num[i] = tmp;
					dfs(cur + 1, num);
					num[i] = num[cur];
					num[cur] = tmp;
				}
			}
		}

	}

	class Nqueues {
		private int count = 0;

		public int totalNQueens(int n) {
			if (n < 3) {
				return 0;
			}
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			queuesDFS(map, 1, n + 1);
			return count;

		}

		public void queuesDFS(Map<Integer, Integer> map, int x, int len) {
			if (x == len) {
				count++;
				return;
			}
			for (int i = 1; i < len; i++) {
				boolean flag = true;
				for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
					if (check(entry.getKey(), entry.getValue(), x, i)) {
						flag = false;
						break;
					}
				}
				if (flag) {
					map.put(x, i);
					queuesDFS(map, x + 1, len);
					map.remove(x);
				}
			}
		}

		public boolean check(int x1, int y1, int x2, int y2) {
			if (y1 == y2 || Math.abs(x1 - x2) == Math.abs(y1 - y2)) {
				return true;
			}
			return false;
		}
	}

	class NqueuesPrint {

		ArrayList<String[]> lists = new ArrayList<>();

		public ArrayList<String[]> solveNQueens(int n) {
			int[] area = new int[n];
			dfs(0, n, area);
			return lists;
		}

		public void dfs(int x, int len, int[] area) {
			if (x == len) {
				String[] strings = new String[len];
				for (int i = 0; i < area.length; i++) {
					StringBuilder sb = new StringBuilder(len);
					for (int j = 0; j < len; j++) {
						if (area[i] != j) {
							sb.append(".");
						} else {
							sb.append("Q");
						}
					}
					strings[i] = sb.toString();
				}
				lists.add(strings);
			} else {
				for (int i = 0; i < len; i++) {
					int j = 0;
					for (; j < x; j++) {
						if (area[j] == i || Math.abs(j - x) == Math.abs(area[j] - i)) {
							break;
						}
					}
					if (j == x) {
						area[x] = i;
						dfs(x + 1, len, area);
					}
				}
			}

		}

	}
}
