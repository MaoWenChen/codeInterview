package thread;

public class Wait_Notify_Insert_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Buck buck = new Buck(false);
			Thread thread = new ThreadA(buck);
			Thread thread2 = new ThreadB(buck);
			thread.start();
			thread2.start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("结束--------------------------------------------------------------------");
		
	}

	static class Buck{
		private boolean flag = true;
		public Buck(boolean flag) {
			this.flag = flag;
		}
		public synchronized void insetA() {
			Thread.yield();        
			try {
				while(flag == true) {
					this.wait();
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			System.out.println("##########");
			flag = true;
			this.notifyAll();
		}
		public synchronized void insertB() {
			try {
				while(flag == false) {
					this.wait();
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			System.out.println("**********");
			this.flag = false;
			this.notifyAll();
		}
	}
	static class ThreadA extends Thread{
		private Buck buck = null;
		public ThreadA(Buck  buck) {
			this.buck = buck;
		}
		@Override
		public void run() {
			for(int i = 0 ;i < 20; i++) {
				buck.insetA();
			}
		}
	}
	static class ThreadB extends Thread{
		private Buck buck = null;
		public ThreadB(Buck  buck) {
			this.buck = buck;
		}
		@Override
		public void run() {
			for(int i = 0 ;i < 20; i++) {
				buck.insertB();
			}
		}
	}
	
}
