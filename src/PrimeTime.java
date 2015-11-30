import java.util.Scanner;

public class PrimeTime {
	static int max = 50007;
	static int mod = 1000000007;
	static int[] nums = new int[max];
	static int k = 0;
	static int[] primes = new int[max];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		boolean[] prime = new boolean[max];
		for (int i = 2; i * i < max; ++i)
			if (!prime[i])
				for (int j = i * i; j < max; j += i)
					prime[j] = true;
		for (int i = 2; i < max; ++i)
			if (!prime[i])
				nums[k++] = i;

		long[] ans = new long[max];

		for (int i = 2; i < max; ++i)
			ans[i] = update(i);

		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			System.out.println(ans[n] % mod);
		}
	}

	private static long update(int n) {
		long ans = 1;
		int count = 0;
		for (int i = 0; i < k; i++) {
			int p = nums[i];
			if (p * p > n)
				break;
			count = 0;
			while (n % p == 0) {
				n /= p;
				primes[p]++;
			}
			if (count != 0)
				ans *= (count + 1);
		}
		if (n != 1)
			primes[n]++;
		for (int i = 0; i < max; ++i)
			if (primes[i] != 0) {
				ans *= (primes[i] + 1);
				ans %= mod;
			}
		return ans % mod;
	}

}
