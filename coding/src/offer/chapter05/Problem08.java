package offer.chapter05;

import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 圆圈中最后一个数字，在0，1，2....n-1组成的n个数中，不停删除第m个数，求最后一个剩下的数
 */
public class Problem08 {

    public static int solution1(int n, int m) {
        if (n < 1 || m < 1)
            throw new IllegalArgumentException("invalid input");
        //创建一个循环链表
        LinkedList<Integer> list = new LinkedList<>(IntStream.range(0, n).boxed().collect(Collectors.toList()));
        int index = 0;
        while (list.size() > 1) {

            for (int i = 0; i < m; i++) {
                index = (index + 1) % list.size();
            }
            list.remove(index);
        }
        return list.getFirst();
    }
    //数学方法:约瑟夫环问题:f(n,m) = [ f(n-1,m) + m ] % n (n>1)，当n=1时，f(n,m)=f(n-1,m)=0
    public static int solution2(int n,int m){
        if (n<1||m<1)
            throw new IllegalArgumentException("invalid input");
        int last = 0;
        for (int i = 2; i <=n ; i++) {
            last = (last + m)%i;
        }

        return last;

    }
}
