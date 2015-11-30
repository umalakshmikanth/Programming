import java.math.BigInteger;
import java.util.Scanner;

public class CommonDIvs {
	static int max = 1007;
	static boolean[] primes = new boolean[max];
	static int k = 0;
	static int[] nums = new int[max];
	static int MAX = 1000000;

	public static void main(String[] args) {
		for (int i = 2; i * i < max; ++i)
			if (!primes[i])
				for (int j = i * i; j < max; j += i)
					primes[j] = true;
		for (int i = 2; i < max; ++i)
			if (!primes[i])
				nums[k++] = i;
		Scanner sc = new Scanner(System.in);
		int[] ans = new int[MAX + 1];
		for (int i = 2; i <= MAX; ++i) {
			if (isPrime(i))
				ans[i] = 2;
			else
				ans[i] = noOfDivs(i);
		}
		int t = sc.nextInt();
		while (t-- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int n = gcd(a, b);
			System.out.println(ans[n]);
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
		if (n % 2 == 0)
			return false;
		if (n < max)
			return !primes[(int) n];
		int r = 0;
		long x = n - 1;
		while (x % 2 == 0) {
			x /= 2;
			r++;
		}
		long d = x;
		int as[] = { 2, 3 };
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

	private static int noOfDivs(int n) {
		if (n == 1)
			return 1;
		int ans = 1;
		for (int i = 0; i < k; ++i) {
			int count = 0;
			int p = nums[i];
			if (p * p > n)
				break;
			if (n % p == 0) {
				while (n % p == 0) {
					n /= p;
					count++;
				}
				ans *= (count + 1);
			}
		}
		return n == 1 ? ans : ans * 2;
	}

	private static int gcd(int a, int b) {
		// TODO Auto-generated method stub
		return b == 0 ? a : gcd(b, a % b);
	}

}
