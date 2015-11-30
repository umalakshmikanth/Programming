package UVA;

import java.math.BigInteger;
import java.util.Scanner;

public class IntegerFact {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n;
		while ((n = sc.nextLong()) != 0) {
			if (isPrime(n))
				System.out.println(n + "^1");
			else
				System.out.println(getAns(n));
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

	private static String getAns(long n) {
		StringBuilder s = new StringBuilder();
		int count = 0;
		if (n % 2 == 0) {
			while (n % 2 == 0) {
				count++;
				n /= 2;
			}
			s.append("2^").append(count).append(" ");
		}
		count = 0;
		if (n % 3 == 0) {
			while (n % 3 == 0) {
				count++;
				n /= 3;
			}
			s.append("3^").append(count).append(" ");
		}
		for (int i = 6; i < n; i += 6) {
			int p = i - 1;
			if (p * p > n)
				break;
			count = 0;
			if (n % p == 0) {
				while (n % p == 0) {
					count++;
					n /= p;
				}
				s.append(p).append("^").append(count).append(" ");
			}
			p = i + 1;
			if (p * p > n)
				break;
			count = 0;
			if (n % p == 0) {
				while (n % p == 0) {
					count++;
					n /= p;
				}
				s.append(p).append("^").append(count).append(" ");
			}
		}
		if (n != 1)
			s.append(n).append("^1");
		return s.toString().trim();
	}

}
