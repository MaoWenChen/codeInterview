package leetCode;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.IntConsumer;

/**
 * Fizz Buzz Multithreaded
 */
public class LeetCode1195 {

    static class FizzBuzz {
        private int n;

        private volatile int currentNum = 1;

        ReadWriteLock rwLock = new ReentrantReadWriteLock();
        Lock readLock = rwLock.readLock();
        Lock writeLock = rwLock.writeLock();

        public FizzBuzz(int n) {
            this.n = n;
        }

        public void fizz(Runnable printFizz) throws InterruptedException {
            while (true) {
                readLock.lock();
                if (currentNum > n) {
                    readLock.unlock();
                    break;
                }

                if (currentNum % 3 == 0 && currentNum %5 != 0) {
                    readLock.unlock();
                    printFizz.run();
                    writeLock.lock();
                    currentNum++;
                    writeLock.unlock();
                } else {
                    readLock.unlock();
                }
            };
        }

        public void buzz(Runnable printBuzz) throws InterruptedException {
            while (true) {
                readLock.lock();
                if (currentNum > n) {
                    readLock.unlock();
                    break;
                }

                if (currentNum % 3 != 0 && currentNum %5 == 0) {
                    readLock.unlock();
                    printBuzz.run();
                    writeLock.lock();
                    currentNum++;
                    writeLock.unlock();
                } else {
                    readLock.unlock();
                }
            };
        }

        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            while (true) {
                readLock.lock();
                if (currentNum > n) {
                    readLock.unlock();
                    break;
                }

                if (currentNum % 3 == 0 && currentNum %5 == 0) {
                    readLock.unlock();
                    printFizzBuzz.run();
                    writeLock.lock();
                    currentNum++;
                    writeLock.unlock();
                } else {
                    readLock.unlock();
                }
            };
        }

        public void number(IntConsumer printNumber) throws InterruptedException {
            while (true) {
                readLock.lock();
                if (currentNum > n) {
                    readLock.unlock();
                    break;
                }

                if (currentNum % 3 != 0 && currentNum %5 != 0) {
                    readLock.unlock();
                    printNumber.accept(currentNum);
                    writeLock.lock();
                    currentNum++;
                    writeLock.unlock();
                }  else {
                    readLock.unlock();
                }
            };
        }
    }


    class Solution2FizzBuzz {
        private int n;
        int k = 1;
        public Solution2FizzBuzz(int n) {
            this.n = n;
        }

        // printFizz.run() outputs "fizz".
        public synchronized void fizz(Runnable printFizz) throws InterruptedException {
            while(k <= n) {
                wait();
                if(k %3 == 0 && k %5 != 0 && k <=n){
                    printFizz.run();
                    // wake up all the waiting threads - number thread
                    notifyAll();
                }

            }
        }

        // printBuzz.run() outputs "buzz".
        public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
            while(k <= n) {
                wait();
                if(k %3 != 0 && k %5 == 0 && k <=n) {
                    printBuzz.run();
                    notifyAll();
                }
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            while(k <= n) {
                wait();
                if(k % 15 == 0 && k <=n) {
                    printFizzBuzz.run();
                    notifyAll();
                }
            }
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public synchronized void number(IntConsumer printNumber) throws InterruptedException {
            while(k <= n) {
                if(k % 3 == 0 || k % 5 == 0) {
                    // Wake up all the threads to Runnable state
                    notifyAll();
                    // Wait to be notified, if threads are done. Assuming, one will do some work
                    wait();
                } else {
                    printNumber.accept(k);
                }
                k++;
            }
            // unlock all the threads
            notifyAll();
        }
    }
}
