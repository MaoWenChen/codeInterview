package thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
	public ArrayList<ArrayList<String>> findLadders(String beginWord, String endWord, HashSet<String> wordList) {
		ArrayList<ArrayList<String>> res = new ArrayList<>();
		Queue<List<String>> queue = new LinkedList<>();
		queue.offer(new ArrayList<>(Arrays.asList(beginWord)));
		Set<String> visited = new HashSet<>();
		Set<String> word_list = new HashSet<>(wordList);
		boolean found = false;
		if (!word_list.contains(endWord))
			return res;
		while (!queue.isEmpty() && !word_list.isEmpty()) {
			for (int i = queue.size(); i > 0; --i) {
				ArrayList<String> path = (ArrayList<String>) queue.poll();
				String back_word = path.get(path.size() - 1);
				for (int j = 0; j < back_word.length(); j++) {
					char[] chs = back_word.toCharArray();
					for (char c = 'a'; c <= 'z'; c++) {
						if (chs[j] == c)
							continue;
						chs[j] = c;
						String next_word = String.valueOf(chs);
						if (next_word.equals(endWord)) {
							path.add(next_word);
							res.add(path);
							found = true;
						}
						if (word_list.contains(next_word)) {
							visited.add(next_word);
							List<String> new_path = new ArrayList<>(path);
							new_path.add(next_word);
							queue.offer(new_path);
						}
					}
				}
			}
			if (found)
				break;
			word_list.removeAll(visited);
			visited.clear();
		}
		return res;
	}
}