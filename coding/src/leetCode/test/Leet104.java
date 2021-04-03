package leetCode.test;

public class Leet104 {
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		return (left > right ? left : right) + 1;
	}
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		String str = "1 2 3 4 5";
		String[] s = str.split(" ",2);
		System.out.println(s.length);
		Class clazz = int.class;
		
	//	Class<Number> cla1= Integer.class; 不能这样转换
		Class<? extends Number> cla1= Integer.class;
//		Number num = cla1.newInstance();
		
		System.out.println(Integer.class.isAssignableFrom(Number.class));
		System.out.println(Integer.class.isAssignableFrom(Integer.class));
		System.out.println(Comparable.class.isAssignableFrom(Integer.class));
		
	
	}
}
