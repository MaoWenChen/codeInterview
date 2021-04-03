package thread;

public class InterruptSleep {

	public static void main(String[] args) throws InterruptedException {
		test();
	}

	public static void test() throws InterruptedException {
		Thread thread = new SleepThread();
		thread.start();
		synchronized (InterruptSleep.class) {
			while (true) {
				Thread.sleep(5000);
				Thread.currentThread().interrupt();
				System.out.println("一直等待");
			}
		}
		
	}
}

class SleepThread extends Thread {

	@Override
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized (InterruptSleep.class) {

			System.out.println("中断要释放锁");

		}
	}

}
