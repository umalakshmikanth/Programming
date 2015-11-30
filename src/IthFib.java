import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class IthFib {
	static int max = 2000000;
	static int pan = 0;
	static int mod = 0;
	static long[] fib = new long[30];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextInt();
		long b = sc.nextInt();
		long p = a;
		long q = b;
		int k = sc.nextInt();
		mod = (int) Math.pow(10, k);
		fib[0] = 0;
		fib[1] = 1;
		for (int i = 2; i < 30; ++i)
			fib[i] = fib[i - 1] + fib[i - 2];

		long c = a + b;
		for (int j = 1; j <= k; ++j)
			pan = pan * 10 + j;
		int i = 3;

		boolean error = true;
		if (isPan(a % mod)) {
			System.out.println("1");
		} else if (isPan((a + b) % mod)) {
			System.out.println("2");
		} else {
			while (i < max) {
				if (isPan(c)) {
					if (isPan(getFib(p, q, i, k))) {
						System.out.println(i);
						error = false;
						break;
					}
				}
				a = b;
				b = c;
				c = a + b;
				c %= mod;
				i++;
			}
			if (error)
				System.out.println("no answer");
		}
	}

	private static long getFib(long a, long b, int n, int k) {
		BigInteger fn1 = get(n - 1);
		BigInteger fn2 = get(n - 2);
		fn1 = fn1.multiply(new BigInteger(b + ""));
		fn2 = fn2.multiply(new BigInteger(a + ""));
		BigInteger ans = fn1.add(fn2);
		return Long.parseLong(ans.toString().substring(0, k));
	}

	private static BigInteger get(int n) {
		BigDecimal phi = new BigDecimal("1.618033988749895");
		BigDecimal si = new BigDecimal("-0.6180339887498949");
		BigDecimal sqr5 = new BigDecimal("2.23606797749979");

		phi = phi.pow(n);
		si = si.pow(n);
		phi = phi.subtract(si);
		return phi.divide(sqr5, 15, RoundingMode.UP).toBigInteger();
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
