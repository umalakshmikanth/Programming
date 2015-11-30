import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class SumOfDivisors {
	static int max = 100000000;
	static boolean[] primes = new boolean[max];
	static int[] nums = new int[max];
	static int k = 0;

	public static void main(String[] args) {

		for (int i = 2; i * i < max; ++i)
			if (!primes[i])
				for (int j = i * i; j < max; j += i)
					primes[j] = true;
		for (int i = 2; i < max; ++i)
			if (!primes[i])
				nums[k++] = i;
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			long n = sc.nextLong();
			if (n < max) {
				if (!primes[(int) n])
					System.out.println("1");
				else
					System.out.println(getSumOfDivs(n));
			} else {
				long val = getSumOfDivs(n).longValue();
				if (val < 0)
					System.out.println("1");
				else
					System.out.println(val);
			}
		}

	}

	private static boolean isPrime(long n) {
		if (n % 2 == 0)
			return false;
		if (n < max) {
			return !primes[(int) n];
		}
		int r = 0;
		long x = n - 1;
		while (x % 2 == 0) {
			x /= 2;
			r++;
		}
		long d = x;
		Random R = null;
		int m = (int) (n % 1000000);
		int min = 3;
		outer: for (int j = 0; j < 18; ++j) {
			int a = R.nextInt((max - min) + 1) + min;
			long y = pow(a, d, n);
			if (y == 1 || y == n - 1)
				continue outer;
			for (int i = 0; i < r; ++i) {
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

	private static long pow(long a, long d, long n) {
		// TODO Auto-generated method stub
		BigInteger A = new BigInteger(a + "");
		A = A.modPow(new BigInteger(d + ""), new BigInteger(n + ""));
		return A.longValue();
	}

	private static BigInteger getSumOfDivs(long n) {
		BigInteger ans = new BigInteger("1");
		long dup = n;
		int count = 0;
		for (int i = 0; i < k; i++) {
			int p = nums[i];
			if ((long) p * p > n)
				break;
			count = 0;
			while (n % p == 0) {
				n /= p;
				count++;
				// System.out.println(p);
			}
			if (count != 0) {
				ans = ans.multiply(new BigInteger((long) (Math.pow(p, count + 1) - 1) + ""));
				ans = ans.divide(new BigInteger((p - 1) + ""));
			}
		}
		if (n != 1) {
			// System.out.println(n);
			ans = ans.multiply(new BigInteger((long) (Math.pow(n, 2) - 1) + ""));
			ans = ans.divide(new BigInteger((n - 1) + ""));
		}
		return ans.subtract(new BigInteger(dup + ""));
	}

}
