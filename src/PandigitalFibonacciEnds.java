import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PandigitalFibonacciEnds {
	static int pan = 0;
	static int max = 2000000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger one = new BigInteger("1");
		BigInteger zero = new BigInteger("0");
		long a = sc.nextLong();
		long b = sc.nextLong();
		int k = sc.nextInt();
		int mod = (int) Math.pow(10, k);
		if (k == 1) {
			if (a == 1)
				System.out.println("1");
		}

		long c = a + b;
		int i = 3;
		for (int j = 1; j <= k; ++j)
			pan = pan * 10 + j;
		boolean error = true;
		while (i < max) {
			if (isPan(c % mod)) {
				long digits = getDigits(a, b, i, k);
				if (isPan(digits)) {
					error = false;
					System.out.println(i + " " + digits);
					break;
				}
			}
			i++;
			a = b;
			b = c;
			c = a + b;
			c = c % mod;
			// System.out.println(i + " " + c);
		}
		if (error)
			System.out.println("no solution");
	}

	private static long getDigits(long a, long b, int n, int d) {
		long fn = get(n - 1, d);
		long fn1 = get(n, d);
		return getVal(fn, fn1, a, b, d);
	}

	private static long getVal(long fn, long fn1, long a, long b, int d) {
		BigInteger A = new BigInteger(fn + "");
		BigInteger B = new BigInteger(fn1 + "");
		A = A.multiply(new BigInteger(b + ""));
		B = B.multiply(new BigInteger(a + ""));
		return Long.parseLong(A.add(B).toString().substring(0, d));
	}

	private static long get(int n, int d) {
		double temp = n * 0.20898764024997873 - 0.3494850021680094;
		return (long) (Math.pow(10, temp - (int) (temp) + d - 1));
	}

	private static boolean isPan(long l) {
		ArrayList<Long> list = new ArrayList();
		while (l > 0) {
			list.add(l % 10);
			l /= 10;
		}
		Collections.sort(list);
		long ans = 0;
		for (int j = 0; j < list.size(); ++j)
			ans = ans * 10 + list.get(j);
		return ans == pan;
	}
}
