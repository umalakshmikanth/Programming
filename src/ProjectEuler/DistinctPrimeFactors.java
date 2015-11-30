package ProjectEuler;

import java.util.Scanner;

public class DistinctPrimeFactors {
	static int max = 1000000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[max];
		for (int i = 1; i < max; ++i)
			arr[i] = getFacs(i);
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		System.out.println(check(arr, k));
	}

	private static String check(int[] arr, int k) {
		int c = 0;
		for (int i = 0; i < arr.length; ++i) {
			if (arr[i] == k)
				c++;
			else
				c = 0;
			if (c == k) {
				System.out.println(i - c + 1);
				return "";
			}
		}
		return "";
	}

	private static int getFacs(int n) {
		int count = 0;
		boolean div = false;
		while (n % 2 == 0) {
			div = true;
			n /= 2;
		}
		if (div)
			count++;
		for (int i = 3; i * i <= n; i += 2) {
			div = false;
			while (n % i == 0) {
				n /= i;
				div = true;
			}
			if (div)
				count++;
		}
		return n == 1 ? count : count + 1;
	}

}
