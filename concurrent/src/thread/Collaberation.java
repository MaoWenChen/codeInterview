package thread;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Exchanger;
import java.util.concurrent.Phaser;
import java.util.concurrent.Semaphore;

/**
 * 测试线程间的协作通信机制
 * 
 * @author mchen
 *
 */
public class Collaberation {

	public static void main(String[] args) throws InterruptedException {
		test5();
	}

	// 测试信号量Semaphore 比lock更进一步，可以控制多个同时访问关键区
	public static void test1() {
		Semaphore semaphore = new Semaphore(1);
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					semaphore.acquire();
					System.out.println("进入临界区");
					Thread.sleep(5000);
					System.out.println("退出临界区");
					semaphore.release();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					semaphore.acquire();
					System.out.println("进入临界区");
					Thread.sleep(5000);
					System.out.println("退出临界区");
					semaphore.release();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		thread1.start();
		thread2.start();
	}

	// 同步辅助类Latch 用于同步执行一个或多个线程,当 Latch的计数器到0的时候所有线程在一起往下执行
	public static void test2() throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(2);
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					latch.await();
					System.out.println("开始考试了");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					latch.await();
					System.out.println("开始考试了");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		thread1.start();
		thread2.start();
		Thread.sleep(2000);
		System.out.println(latch.getCount());
		latch.countDown();
		System.out.println(latch.getCount());
		latch.countDown();
		System.out.println(latch.getCount());

	}

	// barrier 集合点 也是一个同步辅助类,允许多个线程在同一点上同步向前运行
	public static void test3() throws InterruptedException {
		CyclicBarrier barrier = new CyclicBarrier(2);

		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					barrier.await();
					System.out.println("开始考试了");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					barrier.await();
					System.out.println("开始考试了");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		thread1.start();
		Thread.sleep(2000);
		thread2.start();
//		thread2.interrupt();

	}

	// phaser 允许执行并发多阶段任务 同步辅助类
	// 在每个阶段结束的位置对线程进行同步， 当所有的线程都达到这一步就进行下一步的活动
	public static void test4() throws InterruptedException {
		Phaser phaser = new Phaser(3);

		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					phaser.arrive();
					System.out.println(Thread.currentThread().getName() + "开始考试了");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		for (int i = 0; i < 2; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						phaser.arriveAndAwaitAdvance();
						System.out.println(Thread.currentThread().getName() + "开始考试了");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}).start();
		}
		Thread.sleep(2000);
		thread1.start();

	}

	// exchanger允许在并发线程中交互数据, 只能两个线程之间点对点交互，不能指定交互
	//
	public static void test5() {
		Scanner scanner = new Scanner(System.in);
		Exchanger<String> exchanger = new Exchanger<>();

		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					if (!Thread.currentThread().isInterrupted()) {
						try {
							System.err.println("等待交换数据");
							exchanger.exchange("测试交换");
							System.err.println("交换数据成功");
						} catch (InterruptedException e) {
							break;
						}
					} else {
						System.out.println("退出程序");
						break;
					}

				}
			}
		});
		thread.start();
		while (scanner.hasNext()) {
			String tmp = scanner.nextLine();
			if (tmp.equals("end")) {
				break;
			}else {
				try {
					String t = exchanger.exchange(tmp);
					System.out.println("交换过来的数据是"+t);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		thread.interrupt();

	}

}
