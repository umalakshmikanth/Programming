import java.math.BigInteger;
import java.util.Scanner;

public class ProdOFFactorials {
	static long mod = 109546051211L;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long ans = 1;
		for (int i = n, k = 1; i >= 2; --i, ++k) {
			ans *= modPow(i, k, mod);
			ans %= mod;
		}
		System.out.println(ans);
	}

	private static long modPow(int A, int B, long n) {
		BigInteger a = new BigInteger(A + "");
		a = a.modPow(new BigInteger(B + ""), new BigInteger(n + ""));
		return a.longValue();
	}
}
