package algorithm.math;

/**
 * x的二进制
 * 
 * @author mchen
 *
 */
public class BitLength {

	public static int bitLength(int x) {
		int len = 0;
		while (x > 0) {
			x >>= 1;
			len++;
		}
		return len;
	}
}
