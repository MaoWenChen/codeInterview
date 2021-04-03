package flyweight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job> {
	// 线程池最大限制数量
	private static final int MAX_WORKER_NUMBERS = 10;
	// 线程池默认的数量
	private static final int DEFAULT_WORKER_NUMBERS = 5;
	// 线程池最小数量
	private static final int MIN_WORKER_NUMBERS = 1;
	// 工作队列
	private final LinkedList<Job> jobs = new LinkedList<>();
	// 工作者队列
	private final List<Worker> workers = Collections.synchronizedList(new ArrayList<>());
	// 工作者线程的数量
	private int workNum = DEFAULT_WORKER_NUMBERS;
	// 线程编号生成
	private AtomicLong threadNum = new AtomicLong();

	public DefaultThreadPool() {
		initializeWorkers(DEFAULT_WORKER_NUMBERS);
	}

	public void initializeWorkers(int num) {
		for (int i = 0; i < num; i++) {
			Worker worker = new Worker();
			workers.add(worker);
			Thread thread = new Thread(worker, "ThreadPool-worker" + threadNum.incrementAndGet());

		}

	}

	@Override
	public void execute(Job job) {
		if (job != null) {
			synchronized (jobs) {
				jobs.addLast(job);
				jobs.notify();
			}
		}

	}

	@Override
	public void shutdown() {
		for (Worker worker : workers) {
			worker.shutdown();
		}

	}

	@Override
	public void addWorkers(int num) {
		synchronized (jobs) {
			// 限制增加的线程数量不能超过最大的数量
			if (num + this.workNum > MAX_WORKER_NUMBERS) {
				num = MAX_WORKER_NUMBERS - this.workNum;
			}
			initializeWorkers(num);
			this.workNum = this.workNum + num;
		}

	}

	@Override
	public void removeWorker(int num) {
		synchronized (jobs) {
			if (this.workNum < num) {
				throw new IllegalArgumentException("beyond workNum");
			}
			// 按照给定的数量停止worker;
			for (int i = 0; i < num; i++) {
				Worker worker = workers.get(i);
				if (workers.remove(worker)) {
					worker.shutdown();
				}
			}
			this.workNum = this.workNum - num;

		}

	}

	@Override
	public int getJobSize() {
		return jobs.size();
	}

	// 工作线程
	class Worker implements Runnable {
		// 是否工作
		private volatile boolean running = true;

		public void run() {
			while (running) {
				Job job = null;
				synchronized (jobs) {
					// 如果工作队列为空,则等待
					while (jobs.isEmpty()) {
						try {
							jobs.wait();
						} catch (InterruptedException e) {
							// 感知到外部对workthread的中断操作,返回
							Thread.currentThread().interrupt();
							return;
						}

					}
					// 取出第一个Job
					job = jobs.removeFirst();
				}
				if (job != null) {
					try {
						job.run();
					} catch (Exception e) {
						// 忽略job执行中的exception
					}
				}

			}
		}

		public void shutdown() {
			running = false;
		}
	}

}
