package thread;

public class OverSort {
	
	public static void main(String[] args) {
		for(int i = 0;i<5000;i++)
		test1();
	}
	public static void test1() {
		RecoderExample recoderExample = new RecoderExample();
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				recoderExample.writer();
			}
		});
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				recoderExample.reader();
			}
		});
		thread1.start();
		thread2.start();
		
		
	}

}

class RecoderExample {

	int a = 0;
	boolean flag = false;

	public void writer() {
		a = 1;
		flag = true;
	}

	public void reader() {
		if (flag) {
			int i  = a * a;
			System.out.println(i);
		}
	}

}
