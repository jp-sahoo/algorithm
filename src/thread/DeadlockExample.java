package thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.Optional;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockExample {
    private final Lock lock1 = new ReentrantLock();
    private final Lock lock2 = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {
        DeadlockExample d = new DeadlockExample();
        d.execute();
        new Thread(d::findDeadLock).start();
    }

    void findDeadLock() {
        boolean noDeadLock = true;
        while (noDeadLock) {

            ThreadMXBean tmx = ManagementFactory.getThreadMXBean();
            long[] ids = tmx.findDeadlockedThreads();

            if (ids != null) {
                noDeadLock = false;
                ThreadInfo[] infos = tmx.getThreadInfo(ids, true, true);
                System.out.println("The following threads are deadlocked:");
                for (ThreadInfo ti : infos) {
                    System.out.println(ti);
                }
            }
        }
    }

    void execute() {
        //            try {
        //             } catch (InterruptedException e) {
        //                e.printStackTrace();
        //            }
        new Thread(() -> {
            try {
                doSomeA();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(this::doSomeB).start();
    }

    void doSomeA() throws InterruptedException {
        System.out.println("doSomeA preprocessing");
        lock1.lock();
        System.out.println("doSomeA preprocessing after taking lock 1");
        Thread.sleep(1000);
        lock2.lock();
        System.out.println("doSomeA preprocessing after taking lock 1 and 2");
        lock1.unlock();
        lock2.unlock();
    }

    void doSomeB() {
        System.out.println("doSomeB preprocessing");
        lock2.lock();
        System.out.println("doSomeB preprocessing after taking lock 1");
        lock1.lock();
        System.out.println("doSomeB preprocessing after taking lock 1 and 2");
        lock2.unlock();
        lock1.unlock();
    }
}
