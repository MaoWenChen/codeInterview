package leetCode;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.function.IntConsumer;

public class LeetCode1116 {

    static class Solution1ZeroEvenOdd {

        public Solution1ZeroEvenOdd(int n) {
            this.n = n;
        }

        private int n;
        private final AtomicInteger signal = new AtomicInteger(0);
        private final Object lock = new Object();

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            synchronized (this.lock) {
                for (int i = 0; i < this.n; i++) {
                    while (this.signal.get() != 0) {
                        this.lock.wait();
                    }
                    printNumber.accept(0);
                    if (i % 2 == 0) {
                        this.signal.set(1);
                    } else {
                        this.signal.set(2);
                    }
                    this.lock.notifyAll();
                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            synchronized (this.lock) {
                for (int i = 2; i < this.n + 1; i = i + 2) {
                    while (this.signal.get() != 2) {
                        this.lock.wait();
                    }
                    printNumber.accept(i);
                    this.signal.set(0);
                    this.lock.notifyAll();
                }
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            synchronized (this.lock) {
                for (int i = 1; i < this.n + 1; i = i + 2) {
                    while (this.signal.get() != 1) {
                        this.lock.wait();
                    }
                    printNumber.accept(i);
                    this.signal.set(0);
                    this.lock.notifyAll();
                }
            }
        }
    }


    static class Solution2ZeroEvenOdd {

        public Solution2ZeroEvenOdd(int n) {
            this.n = n;
        }

        private int n;
        private static Semaphore z = new Semaphore(1);
        private static Semaphore o = new Semaphore(0);
        private static Semaphore ev = new Semaphore(0);


        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                z.acquire();
                printNumber.accept(0);
                if (i % 2 == 0)
                    ev.release();
                else
                    o.release();
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            for (int i = 2; i <= n; i += 2) {
                ev.acquire();
                printNumber.accept(i);
                z.release();
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i += 2) {
                o.acquire();
                printNumber.accept(i);
                z.release();
            }
        }
    }
}
