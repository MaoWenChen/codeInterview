package leetCode.test;

import java.util.Stack;

public class Leet71 {
	
	public static void main(String[] args) {
		String[] sp = "/../".split("/+");
		System.out.println(sp.length);
	}
	
    public String simplifyPath(String path) {
        String[] sp = path.split("/+");
        Stack<String> stack = new Stack<>();
        for(int i = 0;i<sp.length;i++) {
        	if (!sp[i].equals("")&&!sp[i].equals("..")&&!sp[i].equals(".")) {
				stack.push(sp[i]);
			}else if(sp[i].equals("..")&&!stack.isEmpty()) {
				stack.pop();
			}
        }
        StringBuilder sb = new StringBuilder();
        for(String str: stack) {
        	sb.append("/");
        	sb.append(str);
        }
    	return stack.isEmpty()?"/":sb.toString();
    }

}
