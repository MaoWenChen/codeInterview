package dataStruct.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串替换操作
 *
 */
public class ReplaceString {
	public static void main(String[] args) {
		String orginal = "aaaaabbbbbbbsssssswx";
		String key = "wx";
		String swap = "6";
		System.out.println(repalce4(orginal, key, swap));
		System.out.println(repalce3(orginal, key, swap));

	}

	// 普通方法
	public static String replace1(String orginal, String key, String swap) {
		StringBuilder sb = new StringBuilder(orginal.length());
		int len = key.length();
		for (int i = 0; i < orginal.length();) {
			boolean flag = true;
			for (int j = 0; j < len; j++) {
				if ((i + j) < orginal.length() || orginal.charAt(i + j) == key.charAt(j)) {
					flag = false;
					break;
				}
			}
			if (flag) {
				i = i + len;
				sb.append(swap);
			} else {
				i++;
			}
		}
		return sb.toString();
	}

	// 用kmp匹配算法去进行替换
	public static String repalce2(String orginal, String key, String swap) {
		int len = key.length();
		int[] next = next(key);
		StringBuilder sb = new StringBuilder(orginal.length());
		int k = 0;
		int i = 0;
		int end = 0;
		while (i < orginal.length()) {
			if (k == -1 || key.charAt(k) == orginal.charAt(i)) {
				k++;
				i++;
			} else {
				k = next[k];
			}
			if (k == len) {
				sb.append(orginal.substring(end, i - len));
				sb.append(swap);
				end = i;
				k = 0;
			}

		}
		if (end < orginal.length()) {
			sb.append(orginal.substring(end, orginal.length()));
		}
		return sb.toString();

	}

	public static int[] next(String str) {
		int[] next = new int[str.length()];
		next[0] = -1;
		int k = -1;
		int i = 0;
		while (i < str.length() - 1) {
			if (k == -1 || str.charAt(k) == str.charAt(i)) {
				k++;
				i++;
				next[i] = k;
			} else {
				k = next[k];
			}
		}
		return next;

	}

	// 使用javaAPI进行替换
	public static String repalce3(String orginal, String key, String swap) {
		return orginal.replaceAll(key, swap);
	}

	// 使用正则表达式进行替换
	public static String repalce4(String orginal, String key, String swap) {
		Pattern pattern = Pattern.compile(key);
		Matcher matcher = pattern.matcher(orginal);
		StringBuffer sb = new StringBuffer();
		int start = 0;
		int end = 0;
		while (matcher.find()) {
			end = matcher.start();
			sb.append(orginal.substring(start, end));
			sb.append(swap);
			start = matcher.end();
		}
		sb.append(orginal.substring(start, orginal.length()));
		return sb.toString();
	}

}
