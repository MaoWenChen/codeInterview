package offer.chapter07;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

/**
 * 正则表达式统计(.表示任一数，*表示前面一个字符重复0...n次)
 */
public class Problem03 {
    public static boolean solution(char[] input, char[] pattern) {
        if (input == null || pattern == null) return false;
        return math(input,0,pattern,0);
    }

    public static boolean math(char[] input, int p1, char[] pattern, int p2) {

        if (p1 >= input.length && p2 >= pattern.length) return true;
        //匹配串结束
        if (p1 != input.length && p2 >= pattern.length) return false;

        if (p2 + 1 < pattern.length && pattern[p2 + 1] == '*') {
            if (p1 >= input.length) {
                return math(input, p1, pattern, p2 + 2);
            }
            if (input[p1] == pattern[p2] || pattern[p2] == '.') {
                return math(input, p1 + 1, pattern, p2 + 2)
                        || math(input, p1 + 1, pattern, p2)
                        || math(input, p1, pattern, p2 + 2);
            } else {
                return math(input, p1, pattern, p2 + 2);
            }
        }

        if (input[p1] == pattern[p2] || (pattern[p2] == '.' && p1 != input.length)) {
            return math(input, p1 + 1, pattern, p2 + 1);
        }
        return false;
    }
}
