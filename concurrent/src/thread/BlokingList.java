package thread;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.PriorityBlockingQueue;

public class BlokingList {
	public static void main(String[] args) {
		test3();
	}

	public static void test1() {
		BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(2);
		blockingQueue.add("11");
		blockingQueue.add("22");
		System.out.println(blockingQueue.poll());
		System.out.println(blockingQueue.poll());
	}
	public static void test2() {
		BlockingQueue<String> blockingQueue = new PriorityBlockingQueue<>(1);
		blockingQueue.add("11");
		blockingQueue.add("22");
		System.out.println(blockingQueue.poll());
		System.out.println(blockingQueue.poll());
	}
	public static void test3() {
		List<String> list = new CopyOnWriteArrayList<>();
		list.add("1");
		for(int i = 0;i<4;i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						Thread.sleep(1000);
						System.out.println(list.get(0));
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}).start();
		}
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				list.set(0, "2");
			}
		}).start();
	}
}
