package leetCode.test;

public class Leet44 {
	public static void main(String[] args) {
		System.out.println(isMatch1("aaaa", "***a"));
	}

	// 超时算法
	public static boolean isMatch(String s, String p) {
		if (p.length() == 0 && s.length() == 0) {
			return true;
		} else if (p.length() == 0) {
			return false;
		} else {
			if (p.charAt(0) == '*') {
				return isMatch(s, p.substring(1)) || (s.length() > 0 && isMatch(s.substring(1), p));
			} else if ((p.charAt(0) == '?' && s.length() > 0)
					|| (s.length() > 0 && p.length() > 0 && p.charAt(0) == s.charAt(0))) {
				return isMatch(s.substring(1), p.substring(1));
			} else {
				return false;
			}
		}

	}

	public static boolean isMatch1(String s, String p) {
		int index1 = 0;
		int index2 = 0;
		int tIndex = 0;
		int tIndex2 = 0;
		s += "1";
		p += "1";
		boolean flag = false;
		while (index1 < s.length() && index2 < p.length()) {
			char c1 = s.charAt(index1);
			char c2 = p.charAt(index2);
			if (c1 == c2 || c2 == '?') {
				index1++;
				index2++;
			} else if (c2 == '*') {
				tIndex = ++index2;
				tIndex2 = index1;
				flag = true;
			} else {
				if (flag) {
					index2 = tIndex;
					index1 = ++tIndex2;
				} else {
					return false;
				}
			}
		}
		return index2 >= p.length() ? true : false;
	}

}
