package ProjectEuler;

import java.math.BigInteger;

public class SquareRemainders {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long sum = 0;
		for (int a = 3; a <= 1000; ++a) {
			long rmax = -1;
			// int bestn = 1;
			for (int n = 1; n < 700; ++n) {
				long remainder = getRemainder(a, n);
				if (remainder > rmax) {
					rmax = remainder;
					// bestn = n;
				}
			}
			sum += rmax;
		}
		System.out.println(sum);
	}

	private static long getRemainder(int a, int n) {
		BigInteger A = new BigInteger(a + "");
		BigInteger N = new BigInteger(a + "");
		BigInteger x = A.add(new BigInteger("1"));
		BigInteger y = A.subtract(new BigInteger("1"));
		BigInteger sqr = A.pow(2);
		x = x.modPow(N, sqr);
		y = y.modPow(N, sqr);
		x = x.add(y);
		x = x.mod(sqr);
		return x.longValue();
	}

}
