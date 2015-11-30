import java.util.Scanner;

public class SumOfDivisor {
	static int max = 1000007;
	static boolean[] primes = new boolean[max];
	static int k = 0;
	static int[] nums = new int[max];

	public static void main(String[] args) {
		for (int i = 2; i * i < max; ++i)
			if (!primes[i])
				for (int j = i * i; j < max; j += i)
					primes[j] = true;
		for (int i = 2; i < max; ++i)
			if (!primes[i])
				nums[k++] = i;
		int count = 0;
		int[] sum = new int[max];
		sum[2] = 1;
		for (int i = 2; i < 1000; ++i) {
			k = i * i;
			long divs = getSumOfDivs(k);
			if (divs > 1 && divs < max)
				if (!primes[(int) divs]) {
					 System.out.println(k + " " + Math.sqrt(i));
					count++;
				}
			sum[i] = count;
		}
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(sum[b] - sum[a - 1]);
		}
	}

	private static long getSumOfDivs(int n) {
		long ans = 1;
		for (int i = 0; i < k; ++i) {
			int count = 0;
			int p = nums[i];
			if (p * p > n)
				break;
			while (n % p == 0) {
				n /= p;
				count++;
			}
			if (count != 0) {
				ans *= ((Math.pow(p, count + 1) - 1));
				ans /= (p - 1);
			}
		}
		if (n != 1) {
			ans *= ((Math.pow(n, 2) - 1));
			ans /= (n - 1);
		}
		return ans;
	}

}
