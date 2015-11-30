import java.util.Arrays;
import java.util.Scanner;

public class LCM {
	static int max = 10007;
	static boolean[] primes = new boolean[max];
	static int nums[] = new int[max];
	static int k = 0;
	static long ans[] = new long[max];
	static int p[] = new int[max];
	static int mod = 1000000007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 2; i < max; ++i)
			if (!primes[i])
				for (int j = i * i; j < max; j += i)
					primes[j] = true;
		for (int i = 2; i < max; ++i)
			if (!primes[i])
				nums[k++] = i;
		// System.out.println(Arrays.toString(nums));
		for (int i = 1; i < max; ++i) {
			ans[i] = getAns(i);
			// System.out.println(i + " " + ans[i]);
		}
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			System.out.println(ans[n]);
		}
	}

	private static long getAns(int n) {

		for (int i = 0; i < k; ++i) {
			int count = 0;
			int x = nums[i];
			if (x * x > n)
				break;
			while (n % x == 0) {
				count++;
				n /= x;
				// System.out.println(x);
			}
			if (count != 0) {

				p[x] = count > p[x] ? count : p[x];
			}
		}
		if (n != 1) {
			// System.out.println(n);
			p[n] = 1 > p[n] ? 1 : p[n];
		}
		long ans = 1;
		for (int i = 0; i < k; ++i) {
			int x = nums[i];
			if (p[x] != 0) {
				ans *= (Math.pow(x, p[x]));
				ans %= mod;
			}
		}
		return ans % mod;
	}
}
