package leetCode.test;

public class Leet65 {

	public static void main(String[] args) {
		System.out.println(isNumber(" -90e3  "));
	}

	public static boolean isNumber(String s) {
		  s = s.trim();
			boolean isNumber=false;
			boolean isPositive=false;
			boolean isPoint=false;
			boolean isEp=false;
			int index = 0;
			while(index<s.length()) {
				char c = s.charAt(index);
				if (c=='-'||c=='+') {
					if ((isEp&&!isNumber)||(!isEp&&!isPositive&&!isNumber&&!isPoint)) {
						isPositive = true;
						isNumber = false;
					}else {
						return false;
					}
				}else if((c>='0'&&c<='9')) {
					isNumber = true;
				}else if(c=='E'||c=='e'){
					 if(isNumber&&!isEp) {
						 isEp = true;
						 isNumber = false;
					 }else {
						return false;
					}
				}else if (c=='.') {
					if (!isPoint&& !isEp) {
						isPoint = true;
					}else {
						return false;
					}
				}else{
					return false;
				}
	            index++;
			}
			return isNumber;
	}
}
