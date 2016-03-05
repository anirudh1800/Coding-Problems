class EvenThread implements Runnable {
    Object lock;

    EvenThread(Object lock) {
        super();
        this.lock = lock;
    }

    public void run() {
        for (int i = 2; i <= 100; i += 2)
            synchronized (lock) {
                System.out.println("T2 " + i);
                try {
                    lock.notify();
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }
}

class OddThread implements Runnable {
    Object lock;

    OddThread(Object lock) {
        super();
        this.lock = lock;
    }

    public void run() {
        for (int i = 1; i <= 99; i += 2)
            synchronized (lock) {
                System.out.println("T1 " + i);
                try {
                    lock.notify();
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }

}

class MultiThread {
    public static void main(String args[]) {
        Object sharedLock = new Object();

        Thread t1 = new Thread(new OddThread(sharedLock));
        Thread t2 = new Thread(new EvenThread(sharedLock));

        try {
            t1.start();
            t2.start();

            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}