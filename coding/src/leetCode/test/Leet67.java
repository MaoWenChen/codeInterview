package leetCode.test;

public class Leet67 {
	public static void main(String[] args) {
		System.out.println(addBinary("1010", "1011"));
	}

	public static String addBinary(String a, String b) {
		int indexa = a.length()-1;
		int indexb = b.length()-1;
		int carry = 0;
		StringBuilder sb = new StringBuilder();
		while (indexa >=0 || indexb >=0) {
			int ia = indexa >=0 ? a.charAt(indexa--) - '0' : 0;
			int ib = indexb >=0 ? b.charAt(indexb--) - '0' : 0;
			carry += ia + ib;
			sb.append(carry & 1);
			carry >>= 1;
		}
		if (carry > 0) {
			sb.append(carry);
		}
		return sb.reverse().toString();
	}

}
