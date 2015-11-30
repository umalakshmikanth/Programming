package ProjectEuler;

import java.math.BigInteger;

public class PrimeSquareRemainders {
	static int max = 10000000;
	static boolean[] primes = new boolean[max];
	static long val = 10000000000L;

	public static void main(String[] args) {
		for (int i = 2; i < max; ++i)
			primes[i] = true;
		for (int i = 2; i < max; ++i)
			if (primes[i])
				for (int j = i * i; (long) i * i < max && j < max; j += i)
					primes[j] = false;
		for (int i = 0, k = 1; i < max; ++i)
			if (primes[i]) {
				if (check(i, k) > val) {
					System.out.println(k);
					break;
				}
				k++;
			}
	}

	private static long check(int i, int n) {

		BigInteger ans = new BigInteger("0");
		BigInteger sqr = new BigInteger(i + "");
		sqr = sqr.pow(2);
		BigInteger x = new BigInteger((i - 1) + "");
		x = x.modPow(new BigInteger(n + ""), sqr);
		ans = ans.add(x);
		x = new BigInteger((i + 1) + "");
		x = x.modPow(new BigInteger(n + ""), sqr);
		ans = ans.add(x);

		return Long.parseLong(ans.mod(new BigInteger(sqr + "")).toString());
	}
}
