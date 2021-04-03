package leetCode;

import java.util.concurrent.*;

/**
 * Print in Order
 */
public class LeetCode1114 {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        Solution1Foo foo = new Solution1Foo();
        pool.execute(() -> {
            try {
                foo.first(() -> {
                    System.out.println("first");
                });
            } catch (InterruptedException e) {

            }
        });
        pool.execute(() -> {
            try {
                foo.second(() -> {
                    System.out.println("second");
                });
            } catch (InterruptedException e) {

            }
        });
        pool.execute(() -> {
            try {
                foo.third(() -> {
                    System.out.println("third");
                });
            } catch (InterruptedException e) {

            }
        });
        pool.shutdown();
    }


    static class Solution1Foo {
        volatile boolean waitTwo = true;
        volatile boolean waitThree = true;

        public Solution1Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {

            printFirst.run();
            waitTwo = false;

        }

        public void second(Runnable printSecond) throws InterruptedException {
            while (waitTwo) {
            }

            printSecond.run();
            waitThree = false;
        }

        public void third(Runnable printThird) throws InterruptedException {
            while (waitThree) {
            }

            printThird.run();
        }

    }

    static class Solution2Foo {

        private final CountDownLatch first;
        private final CountDownLatch second;

        public Solution2Foo() {
            first = new CountDownLatch(1);
            second = new CountDownLatch(1);
        }


        public void first(Runnable printFirst) throws InterruptedException {
            printFirst.run();
            first.countDown();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            first.await();
            printSecond.run();
            second.countDown();
        }

        public void third(Runnable printThird) throws InterruptedException {
            second.await();
            printThird.run();
        }
    }

    static class Solution3Foo{
        private Semaphore semaphore1 =new Semaphore(1);
        private Semaphore semaphore2 =new Semaphore(0);
        private Semaphore semaphore3 = new Semaphore(0);

        public void first(Runnable printFirst) throws InterruptedException {
            semaphore1.acquire();
            printFirst.run();
            semaphore2.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            semaphore2.acquire();
            printSecond.run();
            semaphore3.release();
        }

        public void third(Runnable printThird) throws InterruptedException {
            semaphore3.acquire();
            printThird.run();
            semaphore1.release();
        }
    }
}
