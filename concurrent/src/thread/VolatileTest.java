package thread;

public class VolatileTest {

	private int i = 0;
	boolean  flag = true;

	public void add() {
		/*for (int j = 0; j < 10; j++) {
			i++;
		}*/
		flag = false;
	}

	public void show() {
		while(flag) {
			System.err.println(i++);
			for(int j = 0;j<50000000;j++);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		VolatileTest volatileTest = new VolatileTest();
		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
		//		volatileTest.add();
			}
		});
		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				volatileTest.show();
			}
		});
		thread1.start();
		thread2.start();
		Thread.sleep(10);
		volatileTest.flag = false;
		Thread.sleep(5000);
		

	}
}
