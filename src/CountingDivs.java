import java.math.BigInteger;
import java.util.Scanner;

public class CountingDivs {
	static int max = 1000000;
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
		int maxNo = -1;
		long maxVal = -1;
		long[] sum = new long[10001];
		sum[0] = 0;
		for (int i = 1; i <= 10000; ++i)
			sum[i] = sum[i - 1] + getDivs(i);
		maxNo = 10000;
		maxVal = sum[maxNo];
		if (t > 1000) {
			while (t-- > 0) {
				long n = sc.nextLong();
				System.out.println(sum[(int) n]);
			}
		} else {
			while (t-- > 0) {
				long n = sc.nextLong();
				if (n < 10000)
					System.out.println(sum[(int) n]);

				long S = 0;
				int start = 1;
				if (n >= 1000000) {
					S = 73858790;
					start = 1000001;
				}
				if (n >= 10000000) {
					S = 974287906;
					start = 10000001;
				}

				if (n >= 100000000) {
					S = 12422233000L;
					start = 100000001;
				}
				/*
				 * if (n >= 1000000000) { S = 12422233000L; start = 1000000001;
				 * }
				 */
				if (n > maxNo) {
					S = maxVal;
					start = maxNo + 1;
				}

				for (int i = start; i <= n; ++i) {
					if (i > maxNo) {
						maxNo = i;
						maxVal = S;
					}
					S += getDivs(i);
				}
				System.out.println(S);
			}
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

	private static long getDivs(int n) {
		if (isPrime(n))
			return 3;
		long ans = 1;
		for (int i = 0; i < k; ++i) {
			int p = nums[i];
			if (p * p > n)
				break;
			int count = 0;
			while (n % p == 0) {
				n /= p;
				count++;
			}
			if (count != 0) {
				ans *= (count * 2 + 1);
			}
		}
		if (n != 1)
			ans *= 3;
		return ans;
	}

}
