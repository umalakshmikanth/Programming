package ProjectEuler;

public class TruncatablePrimes {
	static int max = 10000000;
	static boolean[] primes = new boolean[max];

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int i = 2; i * i < max; ++i)
			if (!primes[i])
				for (int j = i * i; j < max; j += i)
					primes[j] = true;
		int count = 0;
		for (int i = 11; i < max; ++i)
			if (!primes[i])
				if (canWrite(i)) {
					count++;
					System.out.println(count + " " + i);
				}
		primes[0] = primes[1] = true;
	}

	private static boolean canWrite(int i) {
		int x = 0;
		while (i > 0) {
			x = x * 10 + i % 10;
			i /= 10;
			if (primes[i])
				return false;
		}
		i = x;
		while (i > 0) {
			i /= 10;
			if (primes[i])
				return false;
		}

		return true;
	}

}
