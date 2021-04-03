package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class Main {

	public static void main(String[] args) {
		
		ThreadLocal<StringBuilder> local = new ThreadLocal<>();
		StringBuilder sBuilder = new StringBuilder("aaaaaa");

		String changeString = "V";
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					local.set(sBuilder);
					StringBuilder sbBuilder = local.get();
					System.out.println(Thread.currentThread().getName()+sbBuilder.toString());
					sbBuilder.append(changeString);
				}
			}).start();
			
		}
	}
}
