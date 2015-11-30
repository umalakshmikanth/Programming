import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class MillerRabin {
	static int max = 10007;
	static boolean[] primes = new boolean[max];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 2; i * i < max; ++i)
			if (!primes[i])
				for (int j = i * i; j < max; j += i)
					primes[j] = true;
		Scanner sc = new Scanner(System.in);
		/*
		 * int count = 0; for (int i = 2; i < 100; ++i) if (isPrime(i)) {
		 * count++; System.out.println(i); } System.out.println(count); int t =
		 * sc.nextInt();
		 */while (sc.hasNext()) {
			long n = sc.nextLong();
			System.out.println(isPrime(n) ? "YES" : "NO");
		}

	}

	private static long pow(long a, long d, long n) {
		// TODO Auto-generated method stub
		BigInteger A = new BigInteger(a + "");
		A = A.modPow(new BigInteger(d + ""), new BigInteger(n + ""));
		return A.longValue();
	}

	private static boolean isPrime(long n) {
		if (n < 2)
			return false;
		if (n < max)
			return !primes[(int) n];
		if (n % 2 == 0)
			return false;
		int r = 0;
		long x = n - 1;
		while (x % 2 == 0) {
			x /= 2;
			r++;
		}
		long d = x;
		int as[] = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37 };
		outer: for (int j = 0; j < as.length; ++j) {
			int a = as[j];
			long y = pow(a, d, n);
			if (y == 1 || y == n - 1)
				continue outer;
			for (int i = 0; i < r - 1; ++i) {
				y = pow(y, 2, n);
				if (y == 1)
					return false;
				if (y == n - 1)
					continue outer;
			}
			return false;
		}
		return true;
	}
}
