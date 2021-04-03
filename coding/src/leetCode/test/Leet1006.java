package leetCode.test;

public class Leet1006 {
	
	public static void main(String[] args) {
		System.out.println(clumsy(10));
	}

	public static int clumsy(int N) {

		int op = 0;
		int res = N;
		int div = 0;
		boolean flag = false;
		for (int i = N - 1; i > 0; i--) {
			switch (op) {
			case 0:
				res *= i;
				break;
			case 1:
				res /= i;
				break;
			case 2:
				if (flag) {
					res = div - res+ i;
					div = 0;
					flag = false;
				}else {
					res +=i;
				}
				
				break;

			case 3:
				flag = true;
				div = res;
				res = i;
				break;
			}
			op =(op+1)%4;
		}
		return flag?div - res:res;

	}
}
