package ProjectEuler;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.TreeSet;

public class SQubes {
	static int max = 10000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[] primes = new boolean[max];
		for (int i = 2; i * i < max; ++i)
			if (!primes[i])
				for (int j = i * i; j < max; j += i)
					primes[j] = true;
		int k = 0;
		int[] nums = new int[max];
		for (int i = 2; i < max; ++i)
			if (!primes[i])
				nums[k++] = i;
		TreeSet<BigInteger> set = new TreeSet<>();
		for (int i = 0; i < k; ++i) {
			for (int j = i + 1; j < k; ++j) {
				BigInteger s = get(i, j);
				if (s.toString().contains("200")) {
					set.add(s);
					// System.out.println(set.size() + " " + i + " " + j + " " +
					// s);
				}
				s = get(j, i);
				if (s.toString().contains("200")) {
					set.add(s);
					// System.out.println(set.size() + " " + i + " " + j + " " +
					// s);
				}
			}
		}
		int count = 0;
		System.out.println(canChange("16200"));
		System.exit(0);
		HashSet<BigInteger> set1 = new HashSet();
		for (BigInteger i : set) {
			if (!set1.contains(i) && canChange(i.toString())) {
				System.out.println(i);
				set1.add(i);
				// break;
			}
		}

	}

	private static boolean canChange(String s) {
		for (int i = 0; i <= 9; ++i) {
			for (int j = 0; j < s.length(); ++j) {
				String str = "";
				if (j == 0)
					str = i + s.substring(1, s.length());
				else
					str = s.substring(0, j) + i + s.substring(j + 1);
				System.out.println(str);
				if (isPrime(str)) {
					// System.out.println(str);
					return false;
				}
			}
		}
		return true;
	}

	private static boolean isPrime(String s) {
		long n = Long.parseLong(s);
		if (n % 2 == 0)
			return false;
		for (int i = 3; i * i < n; ++i) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	private static BigInteger get(int i, int j) {
		// TODO Auto-generated method stub
		BigInteger b = new BigInteger(i + "");
		b = b.pow(2);
		BigInteger c = new BigInteger(j + "");
		c = c.pow(3);
		return b.multiply(c);
	}

}
