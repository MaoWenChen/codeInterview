package leetCode.test;

import java.util.ArrayList;
import java.util.List;

public class Leet131 {
	
	
	public static void main(String[] args) {
		Leet131 l = new Leet131();
		System.out.println(l.partition("a"));
	}
	List<List<String>> list = new ArrayList<>();

	public List<List<String>> partition(String s) {

		if (s == null || s.length() < 1) {
			return list;
		}
		dfs(s, new ArrayList<>());
		return list;
	}

	public void dfs(String s, List<String> res) {
		if (s == null || s.length() == 0) {
			list.add(new ArrayList<String>(res));
		} else {
			for (int i = 0, len = s.length(); i < len; i++) {
				if (checkPalindrome(s.substring(0, i + 1))) {
					res.add(s.substring(0, i + 1));
					dfs(s.substring(i+1), res);
					res.remove(res.size() - 1);
				}
			}
		}
	}

	public boolean checkPalindrome(String s) {
		char[] chs = s.toCharArray();
		for (int i = 0; i < chs.length / 2; i++) {
			if (chs[i] != chs[chs.length - 1 - i]) {
				return false;
			}
		}
		return true;
	}

}
