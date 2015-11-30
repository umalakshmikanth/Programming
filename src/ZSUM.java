import java.math.BigInteger;
import java.util.Scanner;

public class ZSUM {
	static long MOD = 10000007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// System.out.println(getPow(2, 10));
		while (sc.hasNext()) {
			long n = sc.nextLong();
			long k = sc.nextLong();
			if (n == 0) {
				System.out.println();
				continue;
			}
			long x = getPow(n - 1, k);
			long y = getPow(n - 1, n - 1);
			long z = getPow(n, k);
			y = (y * 2) % MOD;
			x = (x * 2) % MOD;
			long w = getPow(n, n);
			System.out.println((x + y + z + w) % MOD);
		}
	}

	private static long getPow(long N, long n) {
		// TODO Auto-generated method stub
		long ans = 1;
		int i = 0;
		long x = N % MOD;
		while (n != 1) {
			if (n % 2 == 1) {
				ans *= x;
				ans %= MOD;
			}
			x *= x;
			x %= MOD;
			n = n / 2;
			i++;
		}
		return (ans % MOD * x % MOD) % MOD;
	}

}
