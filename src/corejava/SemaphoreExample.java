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
        Runnable t = new SemaphoreExample();
        ExecutorService service = Executors.newFixedThreadPool(5);
        
        for (int i = 0; i < 5; i++) {
            service.execute(t);
        }
        
        service.shutdown();
    }
    
    public void run() {
        while (System.currentTimeMillis() < endMills) {
            try {
                semaphore.acquire();
            } catch(InterruptedException e ) {
                System.out.println("["+Thread.currentThread().getName()+"] Interrupted in acquire().");
            }
            
            int counterValue = atomicInteger.incrementAndGet();
            System.out.println("["+Thread.currentThread().getName()+"] semaphore acquired: " + counterValue);
            
            if(counterValue > 3) {
				throw new IllegalStateException("More than three threads acquired the lock.");
			}
			atomicInteger.decrementAndGet();
			semaphore.release();
        }
    }
}
