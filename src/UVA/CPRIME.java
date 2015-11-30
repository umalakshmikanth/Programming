package UVA;

import java.util.Arrays;
import java.util.Scanner;

public class CPRIME {
	static int max = 100000000;
	static int k = 0;
	static boolean[] primes = new boolean[max];
	static int[] count = new int[max];

	public static void main(String[] args) {
		for (int i = 2; i * i < max; ++i)
			if (!primes[i])
				for (int j = i * i; j < max; j += i)
					primes[j] = true;
		for (int i = 2; i < max; ++i)
			if (!primes[i])
				count[i] = count[i - 1] + 1;
			else
				count[i] = count[i - 1];
		int n;
		Scanner sc = new Scanner(System.in);
		while ((n = sc.nextInt()) != 0) {
			double x = get(n);
			x = Math.abs(x - count[n]);

			x /= (double) count[n];
			// System.out.println(x);
			x *= 100;
			// System.out.println(x);
			x = (double) Math.round(x * 10) / 10;
			System.out.println(x);
		}
	}

	private static double get(int n) {
		return n / Math.log(n);
	}

}
