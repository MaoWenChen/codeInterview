package leetCode.test;

public class Leet58 {

	public static void main(String[] args) {
		System.out.println(lengthOfLastWord("World"));
	}
	static int lengthOfLastWord(String s) {
		if (s.trim().length()==0) {
			return 0;
		}
		int index = s.lastIndexOf(' ');
		return s.trim().length() - index-1;
	}
}
