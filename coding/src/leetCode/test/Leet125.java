package leetCode.test;

public class Leet125 {

	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
	}

	public static boolean isPalindrome(String s) {
		int start = 0;
		int end = s.length() - 1;
		s = s.toLowerCase();
		while (start < end) {
			while (start<end&&!(s.charAt(start)>='a'&&s.charAt(start)<='z'||s.charAt(start)>='0'&&s.charAt(start)<='9')) {
				start++;
			}
			while (start<end&&!(s.charAt(end)>='a'&&s.charAt(end)<='z'||s.charAt(end)>='0'&&s.charAt(end)<='9')) {
				end--;
			}
			if (start < end && s.charAt(start) != s.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

}
