package ProjectEuler;

import java.util.ArrayList;

public class CircularPrimes {
	static int max = 1000000;
	static boolean[] primes;

	public static void main(String[] args) {
		// TODO Auto-genera-ted method stub4
		primes = new boolean[max];
		for (int i = 2; i * i < max; ++i)
			if (!primes[i])
				for (int j = i * i; j < max; j += i)
					primes[j] = true;

		int k = 0;
		int count = 0;
		for (int i = 2; i < max; ++i) {
			if (primes[i])
				continue;
			if (check(i)) {
				System.out.println(i);
				count++;
			}

		}
		System.out.println(count);
	}

	private static boolean check(int i) {
		int l = i;
		int x = i;
		int d = 1;
		while (x > 0) {
			x /= 10;
			d *= 10;
		}
		d /= 10;
		while (d-- > 0) {
			l = getRotation(l);
			if (primes[l])
				return false;
		}
		return true;
	}

	private static int getRotation(int i) {
		int x = i;
		int d = 1;
		while (x > 0) {
			x /= 10;
			d *= 10;
		}
		d /= 10;
		int p = i / d;
		int num = i % d;
		num *= 10;
		num += p;
		return num;
	}

}
