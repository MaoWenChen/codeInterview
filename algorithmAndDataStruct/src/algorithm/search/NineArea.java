package algorithm.search;

import java.util.ArrayList;
import java.util.List;

public class NineArea {

	public static void main(String[] args) {
		System.out.println(new NineArea().generateAbbreviations("word"));
			
	}

	public List<String> generateAbbreviations(String word) {
		List<String> result = new ArrayList<String>();

		backtrack(result, word, 0, "", 0);

		return result;
	}

	void backtrack(List result, String word, int position, String current, int count) {
		if (position == word.length()) {
			if (count > 0) {
				current += count;
			}

			result.add(current);
		} else {
			backtrack(result, word, position + 1, current + (count > 0 ? count : "") + word.charAt(position), 0);
			backtrack(result, word, position + 1, current, count + 1);
		}
	}

}
