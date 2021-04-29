package multithrading;

import java.util.concurrent.TimeUnit;

public class ThreadSample {
    static Thread thread1 = new Thread(() -> work(5));
    static Thread thread2 = new Thread(() -> work(3));

    static private void work(int sleepingSec){
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+" work.");
                TimeUnit.SECONDS.sleep(sleepingSec);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + " stopped.");
        }
    }

  public static void main(String[] args) {
    thread1.start();
    thread2.start();
  }
}
