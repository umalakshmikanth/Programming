package ProjectEuler;

import java.math.BigInteger;

public class PowerfulDigitSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long sum = -1;
		String p = "";
		for (int i = 0; i < 100; ++i)
			for (int j = 0; j < 100; ++j) {
				long s = getSum(i, j);
				if (s > sum) {
					sum = s;
					p = i + " " + j;
				}

			}
		System.out.println(p + " " + sum);
	}

	private static long getSum(int i, int j) {
		BigInteger a = new BigInteger(i + "");
		a = a.pow(j);
		return sum(a.toString());
	}

	private static long sum(String s) {
		long S = 0;
		for (int i = 0; i < s.length(); ++i)
			S += s.charAt(i) - '0';
		return S;
	}

}
