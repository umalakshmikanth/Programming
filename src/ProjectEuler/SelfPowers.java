package ProjectEuler;

import java.math.BigInteger;

public class SelfPowers {
	static int max = 1001;
	static long mod = 10000000000L;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long ans = 1;
		for (int i = 2; i < max; ++i) {
			ans += getPow(i);
			ans %= mod;
		}
		System.out.println(ans % mod);
	}

	private static long getPow(int i) {
		// TODO Auto-ge-nerated method stub
		BigInteger b = new BigInteger(i + "");
		b = b.modPow(b, new BigInteger(mod + ""));
		return b.longValue();
	}
}
