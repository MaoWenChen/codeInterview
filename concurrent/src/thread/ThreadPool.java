package thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		Runnable task1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("执行任务一");
				
			}
		};
		Runnable task2 = new Runnable() {
			@Override
			public void run() {
				System.out.println("执行任务二");
			}
		};
		executor.execute(task1);
		executor.execute(task2);
		executor.shutdown();
	}
}
