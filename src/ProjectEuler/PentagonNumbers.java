package ProjectEuler;

import java.util.Arrays;

public class PentagonNumbers {
	static int max = 4000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[max];
		for (int i = 1; i < max; ++i)
			arr[i] = (3 * i * i - i) / 2;
		// System.out.println(isPent(92) + " " + isPent(48));
		for (int k = 1; k < 4000; ++k)
			for (int i = 1; i < max - k; ++i)
				if (isPent(arr[i] + arr[i + k]) && isPent(arr[i + k] - arr[i])) {
					System.out.println(i + " " + (i + k) + " " + Math.abs(arr[i] - arr[i + k]));
				}
	}

	private static boolean isPent(int i) {
		double p = Math.sqrt(24 * i + 1) + 1;
		return p % 6 == 0;
	}
}
