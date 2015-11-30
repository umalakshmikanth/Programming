package ProjectEuler;

import java.math.BigInteger;
import java.util.Arrays;

public class PowerDigitSum {
	public static void main(String args[]) {
		int n = 10000;
		System.out.println(getSum(getPow(2, n)));
	}

	private static long getSum(BigInteger pow) {
		// TODO Auto-generated method stub
		long ans = 0;
		String s = pow.toString();
		for (int i = 0; i < s.length(); ++i)
			ans += s.charAt(i) - '0';
		return ans;
	}

	private static BigInteger getPow(int N, int x) {
		BigInteger[] powers = new BigInteger[32];
		powers[0] = new BigInteger(N + "");
		for (int i = 1; i < 15; ++i) {
			powers[i] = powers[i - 1].multiply(powers[i - 1]);
		}
		BigInteger ans = new BigInteger("1");
		int i = 0;
		while (x > 1) {
			if (x % 2 == 1) {
				ans = ans.multiply(powers[i]);
			}
			x /= 2;
			i++;
		}
		return ans.multiply(powers[i]);
	}
}
