package leetCode.test;

import java.util.ArrayList;
import java.util.List;

public class Leet93 {

	public static void main(String[] args) {
		Leet93 leet93 = new Leet93();
		System.out.println(leet93.restoreIpAddresses("25525511135"));
	}

	private List<String> res = new ArrayList<>();

	public List<String> restoreIpAddresses(String s) {
		dfs(4, s, "");
		return res;
	}

	public void dfs(int cur, String s, String list) {
		if (cur == 0) {
			if (s.length() == 0) {
				res.add(list);
			}
		} else {
			if (s.length() > cur * 3 || s.length() < cur) {
				return;
			}
			for (int i = 1, e = s.length(); i <= 3 && i <= e; i++) {
				String tmp = s.substring(0, i);
				int num = Integer.parseInt(tmp);
				if (tmp.length()>1&&tmp.charAt(0)=='0') {
					continue;
				}
				if (num >= 0 && num <= 255) {
					dfs(cur - 1, s.substring(i), "".equals(list) ? tmp : list + "." + tmp);

				}
			}
		}
	}

}
