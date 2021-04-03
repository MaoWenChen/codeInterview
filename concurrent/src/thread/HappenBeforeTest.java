package thread;


import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;

public class HappenBeforeTest {

	private static volatile int i;
	public static void main(String[] args) {
		
	}
	
	public static void test() {
		Thread thread1 = new Thread1();
		Thread thread2 = new Thread2();
		thread1.start();
		thread2.start();
	
		
	}

	static class Thread1 extends Thread{

		@Override
		public void run() {
			for(int j = 0;j<50000;j++);
			i = 1;
			System.out.println(Thread.currentThread().getName()+" over");
		}
		
	}
	
	static class Thread2 extends Thread{

		@Override
		public void run() {
			System.out.println(i);
			System.out.println(Thread.currentThread().getName()+" over");
		}
		
	}
	
	
}
