package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CallableTest {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		test4();
	}

	public static void test() throws InterruptedException, ExecutionException, TimeoutException {
		Callable<Integer> callable = new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				Thread.sleep(1000);
				System.out.println("计算完成");
				return 1;
			}
		};
		FutureTask<Integer> task = new FutureTask<>(callable);
		Thread thread = new Thread(task);
		thread.start();
		if (!task.isDone()) {
			System.out.println("计算结果还没有完成");
			System.out.println(task.get(1,TimeUnit.MILLISECONDS));
		}
		Thread.sleep(1000);
		if (task.isDone()) {
			System.out.println("计算结果完成");
			System.out.println(task.get());
		}
	}
	
	public static void test1() throws InterruptedException, ExecutionException {
		String result = "0";
		RunnableFuture<String> future = new FutureTask<String>(new Runnable() {
			
			@Override
			public void run() {
				
				System.out.println("我计算完成");
			}
		}, result);
		Thread thread = new Thread(future);
		thread.start();
		//让当前线程睡眠
		System.out.println(future.get());
		TimeUnit.MILLISECONDS.sleep(1000);
		System.out.println(Thread.currentThread().getName()+"完成");
	}
	
	public static void test2() throws InterruptedException, ExecutionException {
		Callable<Integer> callable = new Callable<Integer>() {
			 Integer i = 0;
			@Override
			public synchronized Integer call() throws Exception {
	//			TimeUnit.SECONDS.sleep(1);
				System.out.println((i++)+"运行");
				return 1;
			}
			
		};
		FutureTask<Integer> task = new FutureTask<>(callable);
		ExecutorService executor = Executors.newFixedThreadPool(5);
		executor.submit(callable);
		executor.submit(callable);
		Future<Integer> future = (Future<Integer>) executor.submit(callable);
		executor.submit(task);
		executor.submit(task);
		executor.execute(task);
		Future<Integer> future2 = executor.submit(task, 2);
		Thread.sleep(1500);
		System.out.println("返回结果"+task.get());
		Thread.sleep(3000);
		System.out.println(future.get());
		if (!executor.isShutdown()) {
			executor.shutdown();
		}
		Thread.sleep(1000);
		System.out.println(future2.get());
	}
	
	public static void test3() {
		Runnable runnable = new Runnable() {
			public void run() {
				System.out.println(Thread.currentThread().getName()+"运行");
			}
		};
		ExecutorService service = Executors.newFixedThreadPool(3);
		service.submit(runnable);
		service.submit(runnable);
		service.execute(runnable);
		service.execute(runnable);
	}
	
	public static void test4() {
		ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);
		Runnable com = new Runnable() {
			@Override
			public void run() {
				System.out.println("普通任务");
			}
		};
		Runnable cn = new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName()+"定时任务");
			}
		};
		executorService.submit(com);
//		executorService.schedule(cn, 2, TimeUnit.SECONDS);
		executorService.scheduleAtFixedRate(cn, 1, 1, TimeUnit.SECONDS);
//		executorService.scheduleWithFixedDelay(cn, 1, 1, TimeUnit.SECONDS);
	}
}
