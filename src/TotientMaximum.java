
public class TotientMaximum {
	static int max = 10007;
	static boolean[] primes = new boolean[max];
	static int x = 1000000;

	public static void main(String[] args) {
		for (int i = 2; i * i < max; ++i)
			if (!primes[i])
				for (int j = i * i; j < max; j += i)
					primes[j] = true;
		long ans = 1;
		for (int i = 2; i < max; ++i) {
			if (!primes[i]) {
				if (ans * i > x)
					break;
				ans *= i;
			}
		}
		System.out.println(ans);
	}

}
