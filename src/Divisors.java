import java.util.TreeSet;

public class Divisors {
	static int max = 200;
	static boolean[] primes = new boolean[max];
	static int[] nums = new int[max];
	static int k = 0;
	static TreeSet<Integer> set = new TreeSet();
	static int MAX = 1000000;

	public static void main(String[] args) {
		for (int i = 2; i * i < max; ++i)
			if (!primes[i])
				for (int j = i * i; j < max; j += i)
					primes[j] = true;
		for (int i = 2; i < max; ++i)
			if (!primes[i])
				nums[k++] = i;
		for (int i = 0; i < k; ++i) {
			int p = nums[i];
			for (int j = i + 1; j < k; ++j) {
				int q = nums[j];
				markPrimes(p - 1, q - 1);
				markPrimes(q - 1, p - 1);

			}
		}

		int count = 1;
		for (int i : set) {
			count++;
			if (count % 9 == 0)
				System.out.println(i);

		}
	}

	private static void markPrimes(int x, int y) {
		for (int i = 0; i < k; ++i) {
			int p = nums[i];
			for (int j = i + 1; j < k; ++j) {
				int q = nums[j];
				int num = (int) (Math.pow(p, x) * Math.pow(q, y));
				if (num > MAX)
					break;
				set.add(num);
			}

		}
		for (int i = 0; i < k; ++i) {
			int p = nums[i];
			for (int j = i + 1; j < k; ++j) {
				int q = nums[j];
				int num = (int) (Math.pow(q, x) * Math.pow(p, y));
				if (num > MAX)
					break;
				set.add(num);
			}

		}
	}

}
