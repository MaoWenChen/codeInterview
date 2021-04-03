package thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MutexTest {

	private static final  Mutex lock = new Mutex();
	public static void main(String[] args) {
		test();
	}

	public static void test() {
		Thread thread = null;
		for(int i = 0;i<5;i++) {
			thread = new Thread(()->{
				lock.lock();
				try {
					Thread.sleep(1000);
				}catch (Exception e) {
					// TODO: handle exception
				} finally {
					lock.unlock();
				}
			},""+i) ;
			thread.start();
		}
		
	}

}

class Mutex implements Lock {

	private static class Sync extends AbstractQueuedSynchronizer {

		@Override
		protected boolean tryAcquire(int arg) {
			if (compareAndSetState(0, 1)) {
				setExclusiveOwnerThread(Thread.currentThread());
				return true;
			}
			return false;
		}

		@Override
		protected boolean tryRelease(int arg) {

			if (getState() == 0) {
				throw new IllegalMonitorStateException();
			}
			setExclusiveOwnerThread(null);
			setState(0);
			return true;
		}

		@Override
		protected boolean isHeldExclusively() {

			return getState() == 1;
		}

		Condition newCondition() {
			return new ConditionObject();
		}

	}

	private final Sync sync = new Sync();

	@Override
	public void lock() {
		System.out.println(sync.getExclusiveQueuedThreads());
		sync.acquire(1);
	}

	@Override
	public void lockInterruptibly() throws InterruptedException {
		sync.acquireInterruptibly(1);
	}

	@Override
	public boolean tryLock() {
		return sync.tryAcquire(1);
	}

	@Override
	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
		return sync.tryAcquireNanos(1, unit.toNanos(time));
	}

	@Override
	public void unlock() {
		sync.release(1);
	}

	@Override
	public Condition newCondition() {

		return sync.newCondition();
	}

	public boolean isLock() {
		return sync.isHeldExclusively();
	}

	public boolean hasQueuedThreads() {
		return sync.hasQueuedThreads();
	}

	public void tryLockInterruptibly() throws InterruptedException {
		sync.acquireInterruptibly(1);
	}
}
