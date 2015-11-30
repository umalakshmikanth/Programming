package ProjectEuler;

public class PrimeConnections {
	static int max = 1000000;
	static boolean[] primes = new boolean[max];
	static int[] nums = new int[78498];

	public static void main(String[] args) {
		for (int i = 2; i < max; ++i)
			if (!primes[i])
				for (int j = i * i; (long) i * i < max && j < max; j += i)
					primes[j] = true;
		int count = 0;

		for (int i = 2, k = 0; i < primes.length; ++i)
			if (!primes[i])
				nums[k++] = i;

		for (int i = 0; i < nums.length; ++i) {
			check(nums[i], nums[i + 1]);
		}

	}

	private static void check(int i, int j) {
		// TODO Auto-generated method stub
		
	}

}
