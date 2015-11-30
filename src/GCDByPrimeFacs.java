import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class GCDByPrimeFacs {
	static int max = 32000;
	static int[] nums = new int[max];
	static int k = 0;

	static int[] n1 = new int[max];
	static int[] n2 = new int[max];

	public static void main(String[] args) {
		boolean[] primes = new boolean[max];

		for (int i = 2; i * i < max; ++i)
			if (!primes[i])
				for (int j = i * i; j < max; j += i)
					primes[j] = true;
		for (int i = 2; i < max; ++i)
			if (!primes[i])
				nums[k++] = i;
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 0; i < N; ++i) {
			int n = sc.nextInt();
			if (n == 0) {
				Arrays.fill(n1, 0);
				break;
			}
			for (int j = 0; j < k; ++j) {
				int p = nums[j];
				if (p * p > n)
					break;
				if (n % p == 0) {
					while (n % p == 0) {
						n1[p]++;
						n /= p;
					}
				}

			}
			if (n != 1)
				n1[n]++;
		}
		int m = sc.nextInt();
		for (int i = 0; i < m; ++i) {
			int n = sc.nextInt();
			if (n == 0) {
				Arrays.fill(n2, 0);
				break;
			}
			for (int j = 0; j < k; ++j) {
				int p = nums[j];
				if (p * p > n)
					break;
				if (n % p == 0) {
					while (n % p == 0) {
						n2[p]++;
						n /= p;
					}
				}

			}
			if (n != 1)
				n2[n]++;
		}
		BigInteger ans = new BigInteger("1");
		long mod = (int) Math.pow(10, 9);
		boolean error = false;
		for (int i = 0; i < k; ++i) {
			int p = nums[i];
			if (n1[p] == 0 || n2[p] == 0)
				continue;
			ans = ans.multiply(new BigInteger((int) (Math.pow(p, Math.min(n1[p], n2[p]))) + ""));
		}
		String x = ans.toString();
		if (x.length() > 9) {
			System.out.println(x.substring(x.length() - 9));
		} else {
			System.out.println(x);
		}
	}
}
