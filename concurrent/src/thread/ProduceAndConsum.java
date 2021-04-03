package thread;

public class ProduceAndConsum {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		final String lock = "lock";
		final Produce produce = new Produce(lock);
		final Consum consum = new Consum(lock);
		
		Thread thread1  =  new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true)produce.setVlaue();
			}
		});
		Thread thread2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true)consum.getValue();
			}
		});
		thread1.start();
		thread2.start();
		thread1.interrupt();
		thread2.interrupt();
		
	}

}
class Value{
	static String value = "";
}
class Produce{
	String lock = null;
	public Produce(String string) {
		lock = string;
	}
	public void setVlaue() {
		synchronized(lock) {
			if (!"".equals(Value.value)) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
				System.out.println("生产结束");
				}
			}
			String string = System.currentTimeMillis() + "生产";
			Value.value = string;
			lock.notify();
		}
	}
}
class Consum{
	String lock = null;
	public Consum(String string) {
		this.lock = string;
	}
	public void getValue() {
		synchronized (lock) {
			if ("".equals(Value.value)) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println("消费结束");
				}
				
			}
			System.out.println("消费" + Value.value);
			Value.value = "";
			lock.notify();
		}
	}
}
