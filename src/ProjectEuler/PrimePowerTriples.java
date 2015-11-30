package ProjectEuler;

public class PrimePowerTriples {
	static int k = 0;
	static int max = 50000000;
	static boolean[] primes = new boolean[max];
	static int[] nums = new int[max];

	public static void main(String[] args) {
		for (int i = 2; i * i < max; ++i)
			if (!primes[i])
				for (int j = i * i; j < max; j += i)
					primes[j] = true;
		for (int i = 2; i < max; ++i)
			if (!primes[i])
				nums[k++] = i;
		primes[0] = primes[1] = true;
		int count = 0;
		for (int i = 28; i < max; ++i) {
			if (canWrite(i)) {
				//System.out.println(i);
				count++;
			}
		}
		System.out.println(count);
	}

	private static boolean canWrite(int n) {
		for (int i = 0; i < k; ++i) {
			int p = nums[i];
			if (p * p * p * p > n)
				return false;
			for (int j = 0; j < k; ++j) {
				int q = nums[j];
				if (p * p * p * p + q * q * q > n)
					return false;
				if (canBePrimeSquare(n - p * p * p * p - q * q * q)) {
			//		System.out
				//			.println(p * p * p * p + " " + q * q * q + " " + Math.sqrt(n - p * p * p * p - q * q * q));
					return true;
				}

			}
		}
		return false;
	}

	private static boolean canBePrimeSquare(int i) {
		int sqr = (int) Math.sqrt(i);
		if (sqr * sqr == i)
			return !primes[sqr];
		else
			return false;
	}

}
