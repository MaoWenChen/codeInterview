package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

	private static Lock lock = new ReentrantLock();
	
	public static void main(String[] args) throws InterruptedException {
		test();
	}

	public static void test() throws InterruptedException {
		
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				try {
					lock.lockInterruptibly();
					System.out.println("获取锁成功");
					while(!Thread.currentThread().isInterrupted());
					int i = 3/0;
				} catch (Exception e) {
					
				}finally {
					lock.unlock();
					System.out.println("释放锁");
				}
				System.out.println("继续进行");
				
			}
		});
		thread.start();
		Thread.sleep(1000);
		thread.interrupt();
		System.out.println("主线程完成");

	}
}
