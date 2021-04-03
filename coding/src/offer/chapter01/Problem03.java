package offer.chapter01;

/**
 * 把字符串中的每个空格替换成"%20"
 */
public class Problem03 {

    public static int solution(char[] str, int usedLength) {
        if (str == null || str.length < usedLength) {
            return -1;
        }

        // 统计字符数组中的空白字符数
        int cnt = 0;
        for (int i = 0; i < usedLength; i++) {
            if (str[i] == ' ') {
                cnt++;
            }
        }

        // 计算转换后的字符长度是多少
        int targetLength = cnt * 2 + usedLength;
        int tmp = targetLength;
        if (targetLength > str.length) {
            return -1;
        }

        // 如果没有空白字符就不用处理
        if (cnt == 0) {
            return usedLength;
        }

        usedLength--; // 从后向前，第一个开始处理的字符
        targetLength--; // 处理后的字符放置的位置

        // 字符中有空白字符，一直处理到所有的空白字符处理完
        while (usedLength >= 0 && usedLength < targetLength) {
            // 如是当前字符是空白字符，进行"%20"替换
            if (str[usedLength] == ' ') {
                str[targetLength--] = '0';
                str[targetLength--] = '2';
                str[targetLength--] = '%';
            } else { // 否则移动字符
                str[targetLength--] = str[usedLength];
            }
            usedLength--;
        }

        return tmp;
    }

}
