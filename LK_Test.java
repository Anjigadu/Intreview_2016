package javademo;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javademo.LK_Test.Counter;

/**
 *
 * @author debabratatripathy
 */
public class LK_Test {

    static class Counter {

        int cntr = 0;
        //Lock lock = new ReentrantLock();
        ReadWriteLock lock = new ReentrantReadWriteLock();
        
        public int inc() {
            lock.writeLock().lock();
            try {
                cntr++;
            } finally {
                lock.writeLock().unlock();
            }
            return cntr;
        }

        public int get() {
            lock.readLock().lock();
            try {
                return cntr;
            } finally {
                lock.readLock().unlock();
            }
        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter();

        T1 t1 = new T1(counter);
        T1 t2 = new T1(counter);

        new Thread(t1).start();
        new Thread(t2).start();

    }

}

class T1 implements Runnable {

    Counter counter;

    public T1(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(new Random().nextInt(10000));
            } catch (InterruptedException ex) {
                Logger.getLogger(T1.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (new Random().nextInt() % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + " : get : " + counter.get());
            } else {
                System.out.println(Thread.currentThread().getName() + " : inc : " + counter.inc());
            }
        }
    }

}
