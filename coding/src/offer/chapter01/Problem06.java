package offer.chapter01;

import java.util.Stack;

/**
 * 用两个栈模拟的队列
 */
public class Problem06 {

    static class Solution<T>{
        Stack<T> stack1;
        Stack<T> stack2;
        public Solution(){
            this.stack1 = new Stack<>();
            this.stack2 = new Stack<>();
        }
        public void addLast(T t){
            stack2.push(t);
        }
        public T removeFirst(){
            if (stack1.isEmpty()){
                while (!stack2.isEmpty()){
                    stack1.push(stack2.pop());
                }
            }
            if (stack1.isEmpty()){
                throw new RuntimeException("no data");
            }
            return stack1.pop();
        }
    }
}
