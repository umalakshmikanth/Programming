import java.util.BitSet;
import java.util.Scanner;

public class SieveBitSet {
	static int max = 50000;
	static BitSet primes = new BitSet(max);
	static int[] nums = new int[max];
	static int k = 0;

	public static void main(String[] args) {
		for (int i = 2; i * i < max; ++i)
			if (!primes.get(i))
				for (int j = i * i; j < max; j += i)
					primes.set(j, true);
		for (int i = 2; i < max; ++i) {
			if (!primes.get(i))
				nums[k++] = i;
		}
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			markPrimes(a, b);
		}
	}

	private static void markPrimes(int m, int n) {
		int mod = 1000000007;
		BitSet num = new BitSet(mod);
		for (int i = 0; i < k; ++i) {
			if ((long) nums[i] * nums[i] > n)
				break;
			int p = nums[i];
			int x = (m - (m % p));
			for (long j = x; j <= n; j += p) {
				if (j != p)
					num.set((int) j % mod, true);
			}
		}
		int count = 0;
		for (int i = m; i <= n; ++i)
			if (i >= 2 && !num.get(i % mod)) {
				System.out.println(i);
				count++;
			}
		// System.out.println(count + "");

	}

}
