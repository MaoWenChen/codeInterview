package algorithm.math;

/**
 * 不使用除法完成除法运算
 */
public class Divide {
    public static int divide(int dividend, int divisor) {
        int sign = dividend<0?-1:1;
        sign *=divisor<0?-1:1;
        if (divisor==1) {
            return dividend;
        }else if(divisor==-1) {
            return dividend==Integer.MIN_VALUE?Integer.MAX_VALUE:-dividend;
        }
        long di = dividend;
        long div = divisor;
        di = Math.abs(di);
        div = Math.abs(div);
        if (di<div) {
            return 0 ;
        }
        long tmp = div;
        int cnt = 1;
        while(tmp<di) {
            tmp<<=1;
            cnt<<=1;
        }
        while(tmp>di) {
            tmp -=div;
            cnt -=1;
        }
        return sign*cnt;
    }
}
