package thread;

import java.lang.management.ThreadInfo;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalMapTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	//	threadGroup();
		test();
	}
	public static void test() {
		ThreadLocal<String> local = new ThreadLocal<>();
		AtomicInteger local1= new AtomicInteger();
		AtomicInteger local2= new AtomicInteger();
		System.out.println(local1.get());
		System.out.println(local2.get());
		local1.getAndAdd(0x61c88647);
		local2.getAndAdd(0x61c88647);
		System.out.println(local1.get());
		System.out.println(local2.get());
		Thread thread = new Thread(new Runnable() {
			public void run() {
				local.set("移码嘛");
				System.err.println(local.get());
			}
		});
		thread.start();
		System.out.println(local.get());
	}
	
	public static void name() {
		ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
		for (int i = 0; i < 10; i++)
			threadLocal.set(i);
		System.out.println(threadLocal.get());
	}

	public static void threadGroup() throws InterruptedException {
		ThreadGroup group = new ThreadGroup("mygroup");
		group.setMaxPriority(10);
		Thread thread = new Thread(group,new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						break;
					}
					System.out.println(Thread.currentThread().getThreadGroup().getName() + "执行");
				}
			}}
		) ;
		thread.setPriority(5);
		thread.start();
		thread.setName("myThread");
		Thread.sleep(5000);
		System.out.println(group.getMaxPriority());
		System.out.println(thread.getPriority());
		System.out.println(group.getParent().getName());
		System.out.println(group.activeCount());
		System.out.println(group.activeGroupCount());
		group.interrupt();
	}

}
