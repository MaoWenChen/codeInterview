package leetCode.test;

public class Leet43 {
	
	public static void main(String[] args) {
		System.out.println(multiply("99", "99"));
	}
	public static String multiply(String num1, String num2) {
		if (num1.length()==0||num2.length()==0) {
			return "";
		}
		if(num1.charAt(0)=='0'||num2.charAt(0)=='0') {
			return "0";
		}
		int[] res = new int[num1.length()+num2.length()];
		
		for(int i = num1.length()-1;i>=0;i--) {
			int offSet = num1.length()-1-i;
			int carry=0;
			for(int j = num2.length()-1;j>=0;j--) {
				int index = num2.length()-1-j;
				int num = (num1.charAt(i)-'0')*(num2.charAt(j)-'0')+carry+res[offSet+index];
				res[offSet+index]= num%10;
				carry = num/10;
			}
			if (carry!=0) {
				res[offSet+num2.length()]=carry;
			}
		}
		StringBuilder result = new StringBuilder();
		int i = res.length-1;
		for(;i>=0&&res[i]==0;i--) {
		}
		for(;i>=0;i--) {
			result.append(res[i]);
		}
		return result.toString();
	}

}
