package leetCode.test;

public class Leet66 {
	public int[] plusOne(int[] digits) {
		int carry = 1;
		for(int i = digits.length-1;i>=0&&carry>0;i--) {
			carry = carry + digits[i];
			digits[i] = carry%10;
			carry = carry/10;
		}
		int[] res = new int[carry>0?digits.length+1:digits.length];
		System.arraycopy(digits, 0, res, carry>0?1:0, digits.length);
		res[0] = carry>0?carry:res[0];
		return res;
	}

}
