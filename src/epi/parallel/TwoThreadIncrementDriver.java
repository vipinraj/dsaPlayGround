package epi.parallel;
class IncrementThread implements Runnable {
	public void run() {

		synchronized(TwoThreadIncrementDriver.class) {
			for (int i = 0; i < TwoThreadIncrementDriver.N; i++) {
				TwoThreadIncrementDriver.counter++;
			}
		}
	}
}

public class TwoThreadIncrementDriver {
	public static int counter;
	public static int N;

	public static void main(String[] args) throws Exception {
		N = (args.length > 0) ? new Integer(args[0]) : 100;

		Thread t1 = new Thread(new IncrementThread());
		Thread t2 = new Thread(new IncrementThread());
		
		t1.start();
		t2.start();
		//t1.join();
		t2.join();
		System.out.println(counter);
	}
}
/*
   0     1        1    1     2        2
 read-increment-write-read-increment-write
--------
   0     1       1     1     2        2
 read-increment-write-read-increment-write
    0       1      1     1     2        2
   read-increment-write-read-increment-write

*/