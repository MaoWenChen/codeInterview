package thread;

public class VolitaleTest {

	public static void main(String[] args) {
		int i = 0;
		while (i < 100)
			test();
	}

	volatile boolean flag = true;
	int i = 0;

	public static void test() {
		VolitaleTest test = new VolitaleTest();
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				int count = 0;
				while (true && count < 100) {
					if (test.flag) {
						test.i++;
						count++;
						test.flag = false;
					}

				}

			}
		});
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				int count = 0;
				while (true && count < 100) {
					if (!test.flag) {
						test.i++;
						count++;
						test.flag = true;
					}

				}
			}
		});
		thread1.start();
		thread2.start();
		while (Thread.activeCount() > 1) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(test.i);
	}
}
