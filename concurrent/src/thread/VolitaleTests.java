package thread;

public class VolitaleTests {

	public static void main(String[] args) {
		test();
	}

	private static int[] nums = new int[1000];
	static {
		for (int i = 0; i < 1000; i++) {
			nums[i] = i + 1;
		}
	}

	public static void test() {
		AA a = new AA();
		Thread thread = new Thread(() -> {
			for (int i = 0; i < 1000; i++)
			System.out.println(a.i);
		});
		Thread thread1 = new Thread(() -> {
			for (int i = 0; i < 1000; i++)
				a.i = nums[i];
		});
		thread.start();
		thread1.start();
	}
}

class AA {
	public volatile int i = 0;
}