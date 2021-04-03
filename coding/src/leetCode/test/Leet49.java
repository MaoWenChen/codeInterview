package leetCode.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leet49 {

	public List<List<String>> groupAnagrams(String[] strs) {

		List<List<String>> lists = new ArrayList<List<String>>();
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		Arrays.sort(strs);
		for(int i = 0; i<strs.length;i++) {
			char[] tmp = strs[i].toCharArray();
			Arrays.sort(tmp);
			String tmpStr = String.valueOf(tmp);
			if (!map.containsKey(tmpStr)) {
				List<String> list = new ArrayList<>();
				map.put(tmpStr, list);
				lists.add(list);
			}
			map.get(tmpStr).add(strs[i]);
		}
		return lists;
	}
}
