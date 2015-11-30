import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class PsychoNumber {
	static int max = 10000007;
	static boolean[] primes = new boolean[max];
	static int[] nums = new int[max];
	static int k = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			long n = Long.parseLong(br.readLine());
			System.out.println(isPsycho(n) ? "Psycho Number" : "Ordinary Number");
		}
	}

	private static boolean isPsycho(long n) {
		// TODO Auto-generated method stub
		if (n < 2) {
			return false;
		}
		if (isPrime(n)) {
			return false;
		}
		long evenCount = 0;
		long oddCount = 0;
		long count = 0;
		for (int i = 0; i < k; ++i) {
			long p = nums[i];
			if ((long) p * p > n)
				break;
			count = 0;
			while (n % p == 0) {
				n /= p;
				count++;
			}
			if (count != 0) {
				if (count % 2 == 0)
					evenCount++;
				else
					oddCount++;
			}
		}
		if (n > 1)
			oddCount++;
		// System.out.println(oddCount + " " + evenCount);
		return evenCount > oddCount ? true : false;
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
