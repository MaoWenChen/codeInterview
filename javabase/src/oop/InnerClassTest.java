package oop;

public class InnerClassTest {

	public static void main(String[] args) {
		OuterClass outerClass = new OuterClass();
		content con = outerClass.contents();
		System.out.println(con.value());
	}

	public void test(int i, String s) {
		content con = new content() {
			private int i1;
			private String s1;
			{
				this.i1 = i;
				this.s1 = s;
			}

			@Override
			public int value() {
				System.out.println(s);
				return 0;
			}
		};
	}

}

interface content {
	int value();
}

class OuterClass {
	private class Inner implements content {
		private int i = 10;

		@Override
		public int value() {
			return i;
		}
	}

	public content contents() {
		return new Inner();
	}
}