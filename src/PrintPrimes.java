
public class PrintPrimes {
	static int max = 115742;
	static boolean[] primes = new boolean[max];

	public static void main(String[] args) {
		for (int i = 2; i * i < max; ++i)
			if (!primes[i])
				for (int j = i * i; j < max; j += i)
					primes[j] = true;
		for (int i = 2; i < max; ++i)
			if (!primes[i])
				System.out.println(i + " ");

	}
}
