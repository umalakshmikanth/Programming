package ProjectEuler;

public class PrimesSieve {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 2000000;
		boolean[] primes = new boolean[n + 1];
		for (int i = 0; i <= n; i++) {
			primes[i] = false;
		}
		primes[2] = primes[3] = true;
		for (int i = 6; i <= n; i += 6) {
			// System.out.print(i);
			primes[i + 1] = true;
			primes[i - 1] = true;
		}
		for (int i = 5; i <= n; ++i) {
			if (primes[i]) {
				int k = i;
				for (int j = k * k; (long) k * k <= n && j <= n && j > 0; j += k) {
					primes[j] = false;
				}
			}
		}
		long sum = 0;
		for (int i = 0; i <= n; i++)
			if (primes[i])
				sum += i;
		System.out.println(sum);

	}

}
