package ProjectEuler;

import java.math.BigInteger;

public class FactorialTrailingDIgits {
	static long max = 1000000000000L;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long time = System.currentTimeMillis();
		long prev = 1;
		for (long i = 1; i <= max; ++i) {
			if (i % 10 == 0) {
				while (i % 10 != 0)
					i /= 10;
				prev = getFac(prev, i);
				continue;
			}
			prev = getFac(prev, i);
		}
		System.out.println(prev + " " + (System.currentTimeMillis() - time));
	}

	private static long getFac(long prev, long n) {
		long N = n * prev;
		return getLast5(N);
	}

	private static long getLast5(long n) {
		// TODO Auto-generated method stub
		long mod = 1000000;
		while (n % 10 == 0)
			n /= 10;
		return (n % mod);
	}

}
