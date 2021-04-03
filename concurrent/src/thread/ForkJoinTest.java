package thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class ForkJoinTest {
	
	public static void main(String[] args) {
		test();
	}
	public static void test() {
		ForkJoinPool pool = new ForkJoinPool();
		//生成一个计算任务
		CountTask countTask = new CountTask(1, 100);
		//执行一个任务
		Future<Integer> result = pool.submit(countTask);
		try {
			System.out.println(result.get());
		} catch (Exception e) {
			
		}
	}
}

class CountTask extends RecursiveTask<Integer> {

	public static final int THRESHOLD = 2;// 阀值

	private int start;
	private int end;

	public CountTask(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	protected Integer compute() {
		System.out.println(Thread.currentThread().getName());
		int sum = 0;
		boolean canCompute = (end - start) <= THRESHOLD;
		if (canCompute) {
			for (int i = start; i <= end; i++) {
				sum += i;
			}
		} else {
			int middle = (start + end) / 2;
			CountTask leftCountTask = new CountTask(start, middle);
			CountTask rightCountTask = new CountTask(middle + 1, end);
			//执行子任务
			leftCountTask.fork();
			rightCountTask.fork();
			//等待子任务执行完成,并得到其结果
			int leftResult = leftCountTask.join();
			int rightResult = rightCountTask.join();
			//合并子任务
			sum = leftResult + rightResult;
		}
		return sum;
	}

}