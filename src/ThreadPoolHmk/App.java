package ThreadPoolHmk;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
	public static void main(String[] args) {
		final int thread = 100;
		ExecutorService pool = Executors.newFixedThreadPool(thread);
		int n = 100000000;
		final int section = n/thread;
		for (int i=1;i<=thread;i++){
			pool.execute(new PrimeTask(section*(i-1)+1,section*i));
		}
		pool.shutdown();
	}

}
