import java.util.Scanner;

public class PhonyPrimes {
	static int max = 66000;
	static boolean[] primes = new boolean[max];
	static int[] nums = new int[max];
	static int k = 0;

	public static void main(String[] args) {
		for (int i = 2; i * i < max; ++i)
			if (!primes[i])
				for (int j = i * i; j < max; j += i)
					primes[j] = true;
		for (int i = 2; i < max; ++i)
			if (!primes[i])
				nums[k++] = i;
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			if (n == 0 && m == 0)
				break;
			boolean error = false;
			for (int i = n; i <= m; ++i)
				if (isPhony(i)) {
					System.out.println(i);
					error = true;
				}
			if (!error)
				System.out.println("none");
		}
	}

	private static boolean isPhony(int n) {
		int n1 = n - 1;
		int count = 0;
		for (int i = 0; i < k; ++i) {
			int p = nums[i];
			if (p * p > n)
				break;
			if (n % p == 0) {
				count++;
				if (n1 % (p - 1) != 0)
					return false;
				while (n % p == 0)
					n /= p;
			}
		}
		if (n == 1) {
			return count >= 3;
		}
		count++;
		if (count >= 3)
			return n1 % (n - 1) == 0;
		return false;
	}

}
