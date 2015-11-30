import java.util.Scanner;

public class FacDivs {
	static int max = 50000;
	static boolean[] primes = new boolean[max];
	static int[] nums = new int[max];
	static int k = 0;
	static int mod = 1000000007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 2; i * i < max; ++i)
			if (!primes[i])
				for (int j = i * i; j < max; j += i)
					primes[j] = true;
		for (int i = 2; i < max; ++i)
			if (!primes[i])
				nums[k++] = i;
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			long ans = getDivs(n);
			if (ans < 0)
				ans += mod;
			System.out.println(ans);
		}
	}

	private static long getDivs(int n) {
		long ans = 1;
		for (int i = 0; i < k; ++i) {
			int p = nums[i];
			if (p > n)
				break;
			long c = 0;
			int x = p;
			while (n / x > 0) {
				c += n / x;
				x *= p;
			}
			ans *= (c + 1);
			ans %= mod;
		}
		return ans % mod;
	}

}
