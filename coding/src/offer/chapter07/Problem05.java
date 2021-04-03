package offer.chapter07;

import java.io.IOException;
import java.io.Reader;

/**
 * 找出字符流中第一个只出现一次的字符。
 */
public class Problem05 {

    public static char solution(Reader reader) throws IOException {
        if (reader == null) {
            throw new IllegalArgumentException("invalid input");
        }
        int[] words = new int[256];
        int index = 1;
        int ch = -1;
        while ((ch = reader.read()) != -1) {
            if (ch > 255) {
                throw new IllegalArgumentException("must be a ASCII char");
            }
            if (words[ch] == 0) {
                words[ch] = index;
                index++;
            } else {
                words[ch] = -1;
            }
        }
        ch = -1;
        //查找index最小的数
        for (int i = 0; i < words.length; i++) {
            if (words[i] > 0 && words[index] < index) {
                ch = i;
                index = words[index];
            }
        }
        return (char) ch;
    }
}
