package leetCode.test;

import java.util.ArrayList;
import java.util.List;

public class Leet77 {
	private List<List<Integer>> res = new ArrayList<>();
	private boolean[] vis = null;
	
	public static void main(String[] args) {
		Leet77 leet77 = new Leet77();
		System.out.println(leet77.combine(15, 13));
	}

	public List<List<Integer>> combine(int n, int k) {
		if (n <= 0 || k <= 0) {
			return res;
		}
		vis = new boolean[n];
		dfs1(k,1, n, new ArrayList<>());
		return res;

	}

	public void dfs(int k,int cur, int n, List<Integer> list) {
		if (k == 0) {
			res.add(new ArrayList<>(list));
		} else {
			for(int i = cur;i<=n;i++) {
				if (!vis[i-1]) {
					vis[i-1] = true;
					list.add(i);
					dfs(k-1,i+1, n, list);
					list.remove(list.size()-1);
					vis[i-1] = false;
				}
			}
		}
	}
	
	public void dfs1(int k,int cur, int n, List<Integer> list) {
		if (cur==n) {
			if (k==0) {
				res.add(new ArrayList<>(list));
			}
		}
		else if (k == 0) {
			if (cur<=n) {
				res.add(new ArrayList<>(list));
			}
		} else {
			list.add(cur);
			dfs(k-1, cur+1, n, list);
			list.remove(list.size()-1);
			dfs(k, cur+1, n, list);
		}
	}

}
