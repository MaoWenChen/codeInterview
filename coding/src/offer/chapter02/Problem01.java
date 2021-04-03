package offer.chapter02;

/**
 * 求数值的整数次方
 */
public class Problem01 {

    public static double solution(double base, int exp) {
        if ((base == 0 && exp == 0) || (base == 0 && exp < 0))
            return Double.NaN;
        if (exp == 0) return 1;
        double res = pow(base, Math.abs(exp));
        return exp < 0 ? 1 / res : res;
    }

    public static double pow(double base, int exp) {
        if (exp == 0) return 1;
        if (exp == 1) return base;
        double res = pow(base, exp / 2);
        res *= res;
        return (exp & 1) == 1 ? res * base : res;

    }
}
