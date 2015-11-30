package ProjectEuler;

import java.util.ArrayList;
import java.util.HashMap;

public class SegmentedSieve {
	static long max = 10000000000L;
	static int segment = 1000000000;
	static ArrayList<Long> prime = new ArrayList();

	public static void main(String[] args) {
		int sqMax = (int) Math.sqrt(max);
		boolean[] primes = new boolean[sqMax];
		for (int i = 2; (long) i * i < sqMax; ++i)
			if (!primes[i])
				for (int j = i * i; j < sqMax; j += i)
					primes[j] = true;
		for (int i = 2; i < sqMax; ++i)
			if (!primes[i])
				prime.add((long) i);

		for (long i = sqMax; i < max; i += segment) {
			markPrime(i, i + segment);
		}
		System.out.println(prime.size());
	}

	private static void markPrime(long start, long end) {
		int mod = 1000000007;
		if (end > max)
			end = max;
		boolean[] nums = new boolean[mod];
		for (int i = 0; i < prime.size(); ++i) {
			long p = prime.get(i);
			// long x = 0;
			/*
			 * for (long l = start; l < end; ++l) if (l % p == 0) { x = l;
			 * break; }
			 */
			long x = (start - (start % p));
			for (long j = x; j < end; j += p) {
				nums[(int) (j % mod)] = true;
				// System.out.println(p + " " + j + " " + (j % mod));
			}
		}
		for (long i = start; i < end; ++i)
			if (!nums[(int) i % mod])
				prime.add(i);
	}
}
