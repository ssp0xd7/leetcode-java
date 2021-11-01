package 基础算法.多线程打印abc;

public class ThreadPrint implements Runnable {

    private final int PRINT_COUNT = 10;
    private static volatile int flag = 1;

    private Object lock;
    private String value;

    public ThreadPrint(Object lock, String value) {
        this.lock = lock;
        this.value = value;
    }

    @Override
    public void run() {
        for (int i = 0; i < PRINT_COUNT; i++) {
            if (value.equals("A")) {
                synchronized (lock) {
                    while (flag != 1) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println('A');
                    flag = 2;
                    lock.notifyAll(); //提醒A线程开始
                }
            } else if (value.equals("B")) {
                synchronized (lock) {
                    while (flag != 2) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println('B');
                    flag = 3;
                    lock.notifyAll(); //提醒A线程开始
                }
            } else if (value.equals("C")) {
                synchronized (lock) {
                    while (flag != 3) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println('C');
                    flag = 1;
                    lock.notifyAll(); //提醒A线程开始
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Thread a = new Thread(new ThreadPrint(lock, "A"));
        Thread b = new Thread(new ThreadPrint(lock, "B"));
        Thread c = new Thread(new ThreadPrint(lock, "C"));

        a.start();
        b.join();
        b.start();
        c.join();
        c.start();
    }
}
