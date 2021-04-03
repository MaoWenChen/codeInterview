package base;

import java.util.concurrent.TimeUnit;

public class GC {

	public static GC SAVE_HOOK = null;

	public static void main(String[] args) throws InterruptedException {
		SAVE_HOOK = new GC();
		SAVE_HOOK = null;
		System.gc();
		TimeUnit.SECONDS.sleep(1);
		if (SAVE_HOOK == null) {
			System.out.println("对象已经被清理了");
		} else {
			System.out.println("对象还没有被清理");
		}
		if (SAVE_HOOK != null) {
			SAVE_HOOK = null;
		}
		System.gc();
		Thread.sleep(1000);
		if (SAVE_HOOK == null) {
			System.out.println("对象已经被清理了");
		} else {
			System.out.println("对象还没有被清理");
		}
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		SAVE_HOOK = this;
		System.out.println("我复活了");
	}

}
