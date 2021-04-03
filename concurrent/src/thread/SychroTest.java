package thread;

import java.util.Timer;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 线程同步测试
 * 
 * @author Mchen
 *
 */
public class SychroTest {
	ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

	public static void main(String[] args) throws InterruptedException {
		SychroTest test = new SychroTest();
		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					test.test1();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		Thread thread3 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					test.test1();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				test.test2();
			}
		});
		thread1.start();
		thread3.start();
		TimeUnit.SECONDS.sleep(1);
		thread2.start();
	}

	public void test1() throws InterruptedException {
		ReentrantLock lock = new ReentrantLock();

		readWriteLock.readLock().lock();
		System.out.println("正在读锁");
		Thread.sleep(5000);
		System.out.println("完成读取操作");
		readWriteLock.readLock().unlock();

	}

	public void test2() {
		readWriteLock.writeLock().lock();
		System.out.println("正在写数据");
		readWriteLock.writeLock().unlock();
	}

}
