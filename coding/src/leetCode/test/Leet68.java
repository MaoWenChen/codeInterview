package leetCode.test;

import java.util.ArrayList;
import java.util.List;

public class Leet68 {
	public static void main(String[] args) {
		String[] str = new String[] {"This", "is", "an", "example", "of", "text", "justification."};
		System.out.println(fullJustify(str, 16));
	}
	public static List<String> fullJustify(String[] words, int maxWidth) {
		  List<String> list = new ArrayList<>();
			int len = 0;
			StringBuilder sb = null;
			List<String> tmpList = null;
			int i = 0;
			while (i < words.length) {
				sb = new StringBuilder();
				tmpList = new ArrayList<>();
				String one = words[i++];
				len = one.length();
				tmpList.add(one);
				sb.append(one);
				while ((i < words.length)&&(maxWidth - len - 1) >= words[i].length()) {
					len += words[i].length() + 1;
					tmpList.add(words[i++]);
				}
				int empLen = maxWidth - len + tmpList.size() - 1;
				for (int j = 1; j < tmpList.size(); j++) {
					if (i<words.length) {
						for(int k = 0;k<empLen/(tmpList.size()-1);k++) {
							sb.append(" ");
						}
						if (j-1<empLen%(tmpList.size()-1)) {
							sb.append(" ");
						}
					}else {
						sb.append(" ");
					}
					sb.append(tmpList.get(j));
				}
				for(int k = sb.length();k<maxWidth;k++) {
					sb.append(" ");
				}
				list.add(sb.toString());
			}
			return list;

	}

}
