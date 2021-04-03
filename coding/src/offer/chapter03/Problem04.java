package offer.chapter03;

import java.util.Stack;

/**
 * 判断栈的压入顺序是否等于弹出顺序
 */
public class Problem04 {
    public static boolean solution(int[] push, int[] pop) {
        if (push == null || pop == null || push.length == 0 || push.length != pop.length)
            return false;
        Stack<Integer> stack = new Stack<>();
        int pIndex = 0;
        int ppIndex = 0;
        while (ppIndex < pop.length){
            while (!stack.isEmpty()&&pop[ppIndex]==stack.peek()){
                stack.pop();
                ppIndex++;
            }
            if (pIndex<push.length) {
                stack.push(push[pIndex++]);
            }else {
                break;
            }
        }
        return stack.isEmpty();
    }
}
