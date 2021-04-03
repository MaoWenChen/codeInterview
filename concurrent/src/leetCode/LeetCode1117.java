package leetCode;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Building H2O
 */
public class LeetCode1117 {

    static class H2O {

        private ReentrantLock lock;
        int counter;

        public H2O() {
            lock = new ReentrantLock();
            counter = 0;
        }

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            synchronized(lock) {
                while(counter == 2) {
                    lock.wait();
                }
                try {
                    releaseHydrogen.run();
                    counter++;
                }
                finally {
                    lock.notifyAll();
                }
            }
        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {

            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            synchronized(lock) {
                while(counter != 2) {
                    lock.wait();
                }
                try {
                    releaseOxygen.run();
                    counter = 0;
                }
                finally {
                    lock.notifyAll();
                }
            }
        }
    }
}
