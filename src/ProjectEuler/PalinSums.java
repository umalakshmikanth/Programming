package ProjectEuler;

import java.util.Arrays;
import java.util.TreeSet;

public class PalinSums {
	static int max = 100000000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long[] pows = new long[30000];
		TreeSet<Long> list = new TreeSet<>();
		for (int i = 1; i < pows.length; ++i) {
			pows[i] = pows[i - 1] + (i * i);

		}
		long sum = 0;
		for (int i = pows.length - 1; i >= 0; --i) {
			for (int j = 0; j < i - 1; ++j) {
				long x = pows[i] - pows[j];
				if (!list.contains(x) && x <= max && isPalin(x)) {
					sum += x;
					list.add(x);
				}
			}
		}
		System.out.println(sum);
	}

	private static boolean isPalin(long i) {
		long num = 0;
		long dup = i;
		while (i > 0) {
			num = num * 10 + i % 10;
			i /= 10;
		}
		return num == dup;
	}
}
