package ProjectEuler;

import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

public class PalindromicSums {
	static int max = 1000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long[] pows = new long[10000];
		pows[0] = 1;
		TreeSet<Long> list = new TreeSet<Long>();
		pows[0] = 0;
		for (int i = 1, k = 1; i < pows.length; ++i, k++) {
			pows[k] = pows[k - 1] + i * i;
			list.add((long) (i * i));
		}
		System.out.println(Arrays.toString(pows));
		long sum = 0;

		for (int i = pows.length - 1; i >= 1; --i) {
			for (int j = 1; j < i; ++j) {
				if (isPalin(pows[i] - pows[j]))
					list.add(pows[i] - pows[j]);
			}
		}
		// System.out.println(list);
		for (long i = 1; i < max; ++i) {
			if (isPalin(i)) {
				if (list.contains(i)) {
					System.out.println(i);
					sum += i;
				}
			}
		}
		System.out.println(sum);
	}

	private static boolean canWrite(long[] pows, int index, int num) {
		for (int i = index; i >= 0; --i) {
			for (int j = 0; j < i; ++j)
				if (pows[i] - pows[j] == num)
					return true;
		}
		return false;
	}

	private static int bSearch(long[] arr, int x) {
		int low = 0;
		int high = arr.length - 1;
		while (low < high) {
			int mid = (low + high) / 2;
			assert(mid < high);
			long d1 = Math.abs(arr[mid] - x);
			long d2 = Math.abs(arr[mid + 1] - x);
			if (d2 <= d1) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return arr[high] <= x ? (high + 1) : high;

	}

	private static boolean isPalin(long i) {
		long num = 0;
		long dup = i;
		while (i > 0) {
			num = num * 10 + i % 10;
			i /= 10;
		}
		return num == dup;
	}

}
