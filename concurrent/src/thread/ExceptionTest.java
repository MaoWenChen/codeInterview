package thread;

import java.util.concurrent.TimeUnit;

public class ExceptionTest {
	public static void main(String[] args) throws InterruptedException {
		test1();
	}

	public static void test() {
		try {
			System.out.println("执行第一步");
			int i = 3 / 0;
			System.out.println("执行第2步");
		} catch (Exception e) {
			System.out.println("执行第3步");
			throw new RuntimeException();
		}
		System.out.println("执行第4步");
	}
	
	public static void test1() throws InterruptedException {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (this) {
					while(true) {
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							break;
						}
					}
					System.out.println("end");
				}
				
			}
		});
		thread.start();
		TimeUnit.MILLISECONDS.sleep(3);
		thread.interrupt();
		System.out.println("main end");
	}
}
