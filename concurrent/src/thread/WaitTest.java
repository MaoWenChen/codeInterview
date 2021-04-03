package thread;

public class WaitTest {
	
	public static void main(String[] args) {
		WaitTest tes  = new WaitTest();
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					tes.waits();
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
					tes.notifys();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		thread1.start();
		thread2.start();
	}
	

	private Object lock = new Object();

	public synchronized void waits() throws InterruptedException {
		
		while (true) {
			System.out.println("我准备让你停止");
			synchronized (lock) {
				System.out.println("你停止吧");
				lock.wait();
			}
			break;
		}
		System.out.println("我被唤醒了");
	}
	
	public void notifys() throws InterruptedException {
		Thread.sleep(2000);
		synchronized (lock) {
			System.err.println("我通知你唤醒你不在停止");
			lock.notify();
		}
		
	}
}
