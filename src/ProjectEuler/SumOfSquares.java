
import java.util.Scanner;

public class SumOfSquares {
	static int max = 250000;
	static long[] nums = new long[max];

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (long i = 0; i < max; ++i)
			nums[(int) i] = 4 * i + 3;
		while (T-- > 0) {
			long n = sc.nextLong();
			System.out.println((canWrite(n) ? "Yes" : "No"));
		}
	}

	private static boolean canWrite(long n) {
		// TODO Auto-generated method stub
		for (int i = 0; i < nums.length; ++i) {// loop through all the numbers
			if (nums[i] > n)
				return true;
			long count = 0;
			while (n % nums[i] == 0) {
				count++;
				n /= nums[i];
			}
			if (count % 2 != 0) // check for odd frequency
				return false;
		}
		return true;
	}
}