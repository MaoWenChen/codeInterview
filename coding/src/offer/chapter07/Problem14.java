package offer.chapter07;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 数据流中的中位数
 */
public class Problem14 {


    static class Solution {
        Queue<Integer> min = new PriorityQueue<>();
        Queue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

        private void insert(int num) {
            //当前数量是偶数
            if (((min.size() + max.size()) & 1) == 0) {
                if (max.size() > 0 && num < max.peek()) {
                    max.add(num);
                    num = max.remove();
                }
                min.add(num);
            } else {
                if (min.size() > 0 && num > min.peek()) {
                    min.add(num);
                    num = min.remove();
                }
                max.add(num);
            }
        }

        public double getMedian() {
            int size = max.size() + min.size();

            if (size == 0) {
                throw new RuntimeException("No numbers are available");
            }

            if ((size & 1) == 1) {
                return min.peek();
            } else {
                return (max.peek() + min.peek()) / 2.0;
            }
        }
    }
}
