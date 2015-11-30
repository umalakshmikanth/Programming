package ProjectEuler;

import java.math.BigInteger;
import java.util.TreeSet;

public class DigitPowerSum {
	static int max = 1000;

	public static void main(String[] args) {
		// TO-DO Auto-generated method stub
		TreeSet<BigInteger> set = new TreeSet();
		for (int i = 2; i < max; ++i) {
			for (int j = 2; j < 40; ++j) {
				BigInteger b = new BigInteger(i + "");
				b = b.pow(j);
				if (digitSum(b) == i) {
					set.add(b);
					// System.out.println(i + "^" + j + " " + b);
				}
			}
		}
		int count = 1;
		for (BigInteger b : set) {
			System.out.println(count + " " + b);
			count++;
		}
	}

	private static int digitSum(BigInteger S) {
		// TODO Auto-generated method stub
		int sum = 0;
		String s = S.toString();
		for (int i = 0; i < s.length(); ++i)
			sum += (s.charAt(i) - '0');
		return sum;
	}

}
