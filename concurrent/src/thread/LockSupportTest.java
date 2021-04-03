package thread;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class LockSupportTest {

	public static void main(String[] args) throws InterruptedException {
		test();
	}

	public static void test() throws InterruptedException {

		Thread thread = new SupportDemo();
		thread.start();
		Thread.sleep(2000);
		System.out.println(thread.getState());
		LockSupport.unpark(thread);
	}

	private static class SupportDemo extends Thread {

		@Override
		public void run() {
			long start = System.currentTimeMillis();
			while (System.currentTimeMillis() - start < 1000)
				;
			System.out.println("空转1秒");
			LockSupport.park();
			System.out.println(Thread.currentThread().getName() + "是否被中断" + Thread.currentThread().isInterrupted());
			LockSupport.park();
			System.out.println("可以重入");
		}
		
	}
}
