package offer.chapter03;

import java.util.Stack;

/**
 * 包含min函数的栈
 */
public class Problem03 {

    static class Solution<T extends Comparable<T>> {
        Stack<T> stack = new Stack<>();
        Stack<T> stackMin = new Stack<>();

        public void push(T t) {
            if (t == null) {
                throw new RuntimeException("Element can be null");
            }
            T min = t;
            if (!stackMin.isEmpty()&&t.compareTo(stackMin.peek())>0){
                min = stackMin.peek();
            }
            stack.push(t);
            stackMin.push(min);

        }

        public T getMin() {
            if (stackMin.isEmpty()) {
                throw new RuntimeException("empty");
            }
            return stackMin.peek();
        }

        public T pop() {
            if (stack.isEmpty()) {
                throw new RuntimeException("empty");
            }
            stackMin.pop();
            return stack.pop();
        }

    }

}
