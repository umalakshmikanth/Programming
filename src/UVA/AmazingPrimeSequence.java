package UVA;

import java.util.Scanner;

public class AmazingPrimeSequence {
	static int max = 3200;
	static int k = 0;
	static boolean[] primes = new boolean[max];
	static int[] nums = new int[max];
	static int MAX = 10000007;
	static long[] a = new long[MAX];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 2; i * i < max; ++i)
			if (!primes[i])
				for (int j = i * i; j < max; j += i)
					primes[j] = true;
		for (int i = 2; i < max; ++i)
			if (!primes[i])
				nums[k++] = i;
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			System.out.println(getAns(n));
		}

	}

	private static long getAns(int n) {
		if (n <= 1)
			return 0;
		if (a[n] != 0)
			return a[n];

		System.out.println(n + " " + a[n]);
		a[n] = getAns(n - 1) + get(n);
		return a[n];
	}

	private static long get(int i) {
		for (int j = 0; j < k; ++j)
			if (i % nums[j] == 0)
				return nums[j];
		return 0;
	}

}
