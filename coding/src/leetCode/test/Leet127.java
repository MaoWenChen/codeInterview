package leetCode.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leet127 {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> dict = new HashSet<>(wordList);
		Set<String> start = new HashSet<>();
		start.add(beginWord);
		dict.removeAll(start);
		int count = 0;
		boolean flag = false;
		while (!start.isEmpty()) {
			count++;
			if (start.contains(endWord)) {
				flag = true;
				break;
			}
			Set<String> set = new HashSet<>();
			for (String w : start) {
				List<String> po = generatePotential(w, dict);
				if (!po.isEmpty()) {
					set.addAll(po);
				}
			}
			dict.removeAll(set);
			start = set;
		}

		return flag ? count : 0;
	}

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
}
