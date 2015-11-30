package ProjectEuler;

import java.util.Arrays;

public class CosecutivePrimeSum {
	static int max = 1000000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[] primes = new boolean[max];
		for (int i = 2; i * i < max; ++i)
			if (!primes[i])
				for (int j = i * i; j < max; j += i)
					primes[j] = true;
		long[] nums = new long[max];
		nums[0] = 2;
		int k = 1;
		for (int i = 3; i < max; ++i)
			if (!primes[i]) {
				nums[k] = nums[k - 1] + i;
				k++;
			}
		int bestdiff = -1;
		long bestp = -1;
		for (int i = k - 1; i >= 0; --i) {
			for (int j = 0; j < i; ++j) {
				if (nums[i] - nums[j] >= max)
					continue;
				int diff = (int) (nums[i] - nums[j]);
				// System.out.println(diff + " " + nums[i] + " " + nums[j]);
				int l = i - j;
				if (!primes[diff]) {
					if (l > bestdiff) {
						bestdiff = l;
						bestp = diff;
					}
					// System.out.println(diff + " " + (i - j));
				}
			}
		}
		System.out.println(bestdiff + " " + bestp);
	}

}
