import java.util.Arrays;
import java.util.Scanner;

public class NDivisors {
	static int max = 1000000;
	static boolean[] primes = new boolean[max];
	static int[] nums = new int[max];
	static int k = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 2; i * i < max; ++i)
			if (!primes[i])
				for (int j = i * i; j < max; j += i)
					primes[j] = true;
		for (int i = 2; i < max; ++i)
			if (!primes[i])
				nums[k++] = i;
		// System.out.println(Arrays.toString(nums));
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		long n = sc.nextLong();
		long count = 0;
		for (long i = a; i <= b; ++i) {

			if (getNumDivs(i) == n) {
				count++;
				// System.out.println(i + " " + getNumDivs(i));
			}
		}
		System.out.println(count);
	}

	private static int getNumDivs(long n) {
		int count = 1;
		for (int i = 0; i < k; ++i) {
			int p = nums[i];
			if ((long) p * p > n)
				break;
			int c = 0;
			while (n % p == 0) {
				// System.out.println(p);
				c++;
				n /= p;
			}
			if (c != 0)
				count *= (c + 1);
		}
		return n == 1 ? count : count * 2;
	}
}
