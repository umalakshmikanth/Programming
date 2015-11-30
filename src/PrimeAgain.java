
public class PrimeAgain {
	static boolean[] primes = new boolean[(int) Math.pow(2, 32)];

	public static void main(String[] args) {
		for (int i = 2; i * i < primes.length; ++i)
			if (!primes[i])
				for (int j = i * i; j < primes.length; j += i)
					primes[j] = true;
		int k = 0;
		int[] nums = new int[primes.length];
		for (int i = 2; i < primes.length; ++i)
			if (!primes[i])
				nums[k++] = i;

		System.out.println(k);
	}

}
