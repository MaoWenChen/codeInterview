package leetCode.test;

import java.util.HashMap;
import java.util.Map;

public class Leet76 {

	public String minWindow(String s, String t) {
		int max = Integer.MAX_VALUE;
		String res = "";
		if (t.length() == 0) {
			return res;
		}
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int count = t.length();
		for (char c : t.toCharArray()) {
			if (!map.containsKey(c)) {
				map.put(c, 0);
			}
			map.put(c, map.get(c) + 1);
		}
		int start = 0;
		int end = 0;
		while (end < s.length()) {
			char c = s.charAt(end++);
			if (map.containsKey(c)) {
				if (map.get(c) > 0) {
					count--;
				}
				map.put(c, map.get(c) - 1);
			}
			while (count == 0) {
				if (max > end - start) {
					res = s.substring(start, end);
					max = end - start;
				}
				c = s.charAt(start++);
				if (map.containsKey(c)) {
					if (map.get(c) == 0) {
						count++;
					}
					map.put(c, map.get(c) + 1);
				}
			}
		}
		return res;
	}

	public String minWindow1(String s, String t) {
		int[] ch = new int[26];
		boolean[] cb = new boolean[26];
		for (char c : t.toCharArray()) {
			ch[c - 'A']++;
			cb[c - 'A']=true;
		}
		int count = t.length();
		String cs  = "";
		int max = Integer.MAX_VALUE;
		for (int end = s.length(),start=0, i = 0; i < end; i++) {
			char c = s.charAt(i);
			if (cb[c-'A']) {
				if (ch[c-'A']>0) {
					count--;
				}
				ch[c - 'A']--;
			}
			
			while(count == 0) {
				if (i-start+1<max) {
					cs = s.substring(start,i+1);
					max = i-start+1;
				}
				c = s.charAt(start++);
				if (cb[c-'A']) {
					if (ch[c-'A']==0) {
						count++;
					}
					ch[c - 'A']++;
				}
			}
		}
		return cs;
	}

}
