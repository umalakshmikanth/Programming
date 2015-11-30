package UVA;

import java.util.Arrays;
import java.util.Scanner;

public class Equations {
	static int mod = 1000007;
	static int max = 1000000;
	static int k = 0;
	static boolean[] primes = new boolean[max];
	static int[] nums = new int[max];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 2; i * i < max; ++i)
			if (!primes[i])
				for (int j = i * i; j < max; j += i)
					primes[j] = true;
		for (int i = 2; i < max; ++i)
			if (!primes[i])
				nums[k++] = i;
	//	System.out.println(Arrays.toString(nums));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(getAns(n));
	}

	private static int getAns(int n) {
		long ans = 1;
		for (int i = 0; i < k; ++i) {
			int p = nums[i];
			if (p > n)
				break;
			int count = 0;
			long x = p;
			while (n / x > 0) {
				count += n / x;
				x *= p;
			}
		//	System.out.println(p + " " + count);
			ans *= (2 * count + 1);
			ans %= mod;
		}
		return (int) ans;
	}

}
