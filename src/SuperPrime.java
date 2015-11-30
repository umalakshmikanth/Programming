
public class SuperPrime {
	static int max = 10000000;
	static boolean[] primes = new boolean[max];
	static int k = 0;
	static int[] nums = new int[max];

	public static void main(String[] args) {
		for (int i = 2; i * i < max; ++i)
			if (!primes[i])
				for (int j = i * i; j < max; j += i)
					primes[j] = true;
		for (int i = 2; i < max; ++i)
			if (!primes[i])
				nums[k++] = i;
		for (int i = 0; i < k; ++i) {
			if (nums[i] < k)
				System.out.println(nums[nums[i] - 1]);
		}
	}

}
