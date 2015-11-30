package ProjectEuler;

public class Primality2n21 {
	static int max = 50000000;
	static int m = 100000000;
	static boolean[] primes = new boolean[m];
	static int[] nums = new int[m];
	static int k;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 2; i * i < m; ++i)
			if (!primes[i])
				for (int j = i * i; j < m; j += i)
					primes[j] = true;
		for (int i = 2; i < m; ++i)
			if (!primes[i])
				nums[k++] = i;

		int count = 0;
		for (int i = 2; i <= max; ++i)
			if (isPrime((long) 2 * i * i - 1)) {
				// System.out.println((long) 2 * i * i - 1);
				count++;
			}
		System.out.println(count);
	}

	private static boolean isPrime(long l) {
		for (int i = 0; nums[i] < l && i < k; ++i)
			if (l % nums[i] == 0)
				return false;
		return true;
	}

}
