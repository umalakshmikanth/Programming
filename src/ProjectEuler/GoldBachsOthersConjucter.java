package ProjectEuler;

import java.util.Arrays;

public class GoldBachsOthersConjucter {
	static int max = 10000;
	static int[] nums = new int[max];
	static int k = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[] primes = new boolean[max];
		for (int i = 2; i * i < max; ++i)
			if (!primes[i])
				for (int j = i * i; j < max; j += i)
					primes[j] = true;
		for (int i = 2; i < max; ++i)
			if (!primes[i])
				nums[k++] = i;
		for (int i = 3; i < max; i += 2) {
			if (!primes[i])
				continue;
			if (!canWrite(i)) {
				System.out.println(i);
				break;
			}
		}
	}

	private static boolean canWrite(int num) {
		// TODO Auto-generated method stub
		for (int i = 0; i < k; ++i) {
			if (num - nums[i] < 0)
				return false;
			if (isSqr((num - nums[i]) / 2))
				return true;
		}
		return false;
	}

	private static boolean isSqr(int i) {
		if (i == 1)
			return true;
		int p = (int) Math.sqrt(i);
		return p * p == i;
	}

}
