import java.util.Scanner;

public class PrimeGenerator {
	static int max = 32600;
	static int mod = 10000007;

	public static void main(String[] args) {
		boolean[] primes = new boolean[max];
		for (int i = 2; i * i < max; ++i)
			if (!primes[i])
				for (int j = i * i; j < max; j += i)
					primes[j] = true;
		int[] nums = new int[max];
		int k = 0;
		for (int i = 2; i < max; ++i)
			if (!primes[i])
				nums[k++] = i;
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			boolean[] arr = new boolean[mod];
			for (int i = 0; i < k; ++i) {
				if ((long) nums[i] * nums[i] > n)
					break;
				int p = nums[i];
				int x = (m - (m % p));
				for (long j = x; j <= n; j += p) {
					if (j != p)
						arr[(int) j % mod] = true;
				}
			}
			int count = 0;
			for (int i = m; i <= n; ++i)
				if (i >= 2 && !arr[i % mod]) {
					System.out.println(i);
					count++;
				}
			System.out.println(count + "");
		}
	}

}
