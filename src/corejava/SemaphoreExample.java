package corejava;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class SemaphoreExample implements Runnable {
    private static final Semaphore semaphore = new Semaphore(3, true);
    private static final AtomicInteger atomicInteger = new AtomicInteger();
    private static final long endMills = System.currentTimeMillis() + 10000;
    
    public static void main(String[] args) {
        //Runnable t = new SemaphoreExample();
        //ExecutorService service = Executors.newFixedThreadPool(5);
        
        //for (int i = 0; i < 1; i++) {
        //    service.execute(t);
        //}
        
        //service.shutdown();

        Thread t1 = new Thread(new SemaphoreExample());
        Thread t2 = new Thread(new SemaphoreExample());
        Thread t3 = new Thread(new SemaphoreExample());
        Thread t4 = new Thread(new SemaphoreExample());
        Thread t5 = new Thread(new SemaphoreExample());
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        try {
            t5.join();
        } catch(InterruptedException e) {
        }
    }
    
    public void run() {
        while (System.currentTimeMillis() < endMills) {
            try {
                semaphore.acquire();
            } catch(InterruptedException e ) {
                System.out.println("["+Thread.currentThread().getName()+"] Interrupted in acquire().");
                System.exit(0);
            }
            
            int counterValue = atomicInteger.incrementAndGet();
            System.out.println("["+Thread.currentThread().getName()+"] semaphore acquired: " + counterValue);
            
            if(counterValue > 3) {
                System.exit(0);
				throw new IllegalStateException("More than three threads acquired the lock.");
			}
			atomicInteger.decrementAndGet();
			semaphore.release();
        }
    }
}
