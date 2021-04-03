package leetCode.test;

import java.util.*;

public class Leet126 {

	// 超时算法
	private int min = Integer.MAX_VALUE;
	Map<Integer, List<List<String>>> map = new HashMap<Integer, List<List<String>>>();

	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

		List<String> list = new ArrayList<>();
		list.add(beginWord);
		map.put(min, new ArrayList<>(0));
		dfs(beginWord, endWord, wordList, list);
		return map.get(min);
	}

	private void dfs(String beginWord, String endWord, List<String> wordList, List<String> tmp) {
		if (beginWord.equals(endWord)) {
			if (!map.containsKey(tmp.size())) {
				map.put(tmp.size(), new ArrayList<>());
			}
			map.get(tmp.size()).add(tmp);
			min = Math.min(min, tmp.size());
			return;
		}
		String t = null;
		List<String> tmpList = null;
		for (int i = 0, len = wordList.size(); i < len; i++) {
			t = wordList.get(i);
			if (hasPath(beginWord, t)) {
				tmpList = new ArrayList<>(wordList);
				tmpList.remove(i);
				List<String> tList = new ArrayList<>(tmp);
				tList.add(t);
				dfs(t, endWord, tmpList, tList);
			}
		}
	}

	private boolean hasPath(String w1, String w2) {
		int count = 0;
		if (w1.length() != w2.length()) {
			return false;
		}
		for (int i = 0, len = w1.length(); i < len; i++) {
			if (w1.charAt(i) != w2.charAt(i)) {
				count++;
			}
		}
		return count == 1 ? true : false;
	}

}

class Leet126test {

	public List<String> generatePotential(String beginWord, Set<String> wordList) {
		List<String> list = new ArrayList<>();
		char[] chars = beginWord.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			char o = chars[i];
			for (char c = 'a'; c <= 'z'; c++) {
				if (c == o) {
					continue;
				}
				chars[i] = c;
				String newWrod = new String(chars);
				if (wordList.contains(newWrod)) {
					list.add(newWrod);
				}
			}
			chars[i] = o;
		}
		return list;
	}

	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		Set<String> dict = new HashSet<>(wordList);
		Set<String> start = new HashSet<>();
		start.add(beginWord);
		dict.removeAll(start);

		Map<String, List<String>> map = new HashMap<>();
		List<List<String>> res = new ArrayList<>();

		while (!start.isEmpty()) {
			if (start.contains(endWord)) {
				break;
			}
			Set<String> set = new HashSet<>();
			for (String w : start) {
				List<String> po = generatePotential(w, dict);
				if (!po.isEmpty()) {
					map.put(w, po);
					set.addAll(po);
				}
			}
			dict.removeAll(set);
			start = set;
		}

		List<String> temp = new ArrayList<>();
		temp.add(beginWord);
		dfs(beginWord, endWord, map, res, temp);
		return res;
	}

	private void dfs(String beginWord, String endWord, Map<String, List<String>> map, List<List<String>> res,
			List<String> temp) {
		if (beginWord.equals(endWord)) {
			res.add(new ArrayList<>(temp));
			return;
		}
		if (map.containsKey(beginWord)) {
			for (String w : map.get(beginWord)) {
				temp.add(w);
				dfs(w, endWord, map, res, temp);
				temp.remove(temp.size() - 1);
			}
		}

	}
}
