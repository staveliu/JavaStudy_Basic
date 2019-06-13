package ThreadPoolHmk;

import java.util.Set;
import java.util.TreeSet;

public class PrimeTask implements Runnable{
	private int start;
	private int end;

	public PrimeTask(int start,int end) {
		this.start = start;
		this.end = end;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	@Override
	public void run() {
		int n=0;
		long startTime = System.currentTimeMillis();
		for (int i=start;i<=end;i++) {
			if (Mathutil.isPrime(i)) {
				n++;
			}
		}
		long endTime = System.currentTimeMillis() - startTime;
		System.out.println(Thread.currentThread().getName() + "\tGet\t" + n + "Primes" + "\tSpend Time:" + endTime+"ms");
	}
}
