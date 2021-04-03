package leetCode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Print FooBar Alternately
 */
public class LeetCode1115 {
    public static void main(String[] args) {
        Solution1FooBar fooBar = new Solution1FooBar(3);
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(() -> {
            try {
                fooBar.foo(() -> {
                    System.out.println("foo");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executor.execute(() -> {
            try {
                fooBar.bar(() -> {
                    System.out.println("bar");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executor.shutdown();
    }


    static class Solution1FooBar {
        private int n;
        private boolean print = true;

        public Solution1FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {

                synchronized (this) {
                    while (!print) {
                        this.wait();
                    }
                    printFoo.run();
                    print = false;
                    this.notifyAll();
                }


            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {

                // printBar.run() outputs "bar". Do not change or remove this line.
                synchronized (this) {
                    while (print) {
                        this.wait();
                    }
                    printBar.run();
                    print = true;
                    this.notifyAll();
                }
            }
        }
    }

    static class Solution2FooBar {
        private int n;
        private volatile int k = 1;

        Solution2FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException{
            for (int i = 0; i < n; i++) {
                while ((k & 1) == 1) {
                    Thread.yield();
                }
                printFoo.run();
                k ^= 1;
            }
        }
        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                while ((k & 1) == 0){
                    Thread.yield();
                }
                printBar.run();
                k ^=1;
            }
        }

    }

}
