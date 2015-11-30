import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class SumarAndFloatingRocks {
	static int max = 100;
	static boolean[] primes = new boolean[max];

	public static void main(String[] args) {
		primes[2] = primes[3] = primes[5] = true;

		for (int i = 6; i <= max; i += 6) {
			new myThread(i - 1);

		}
	}

	public class myThread {
		Thread t;

		public myThread()
		{
			
		}
		public myThread(int i) {
			t = new Thread();
			t.run();
		}
		
		public void run() {

		}
	}
}
