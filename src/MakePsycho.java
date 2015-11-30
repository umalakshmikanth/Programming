import java.util.Scanner;

public class MakePsycho {
	static int max = 1100;
	static boolean[] primes = new boolean[max];
	static int[] nums = new int[max];
	static int k = 0;
	static boolean[] psys = new boolean[max];

	public static void main(String[] args) {
		for (int i = 2; i * i < max; ++i)
			if (!primes[i])
				for (int j = i * i; j < max; j += 2)
					primes[j] = true;
		for (int i = 2; i < max; ++i)
			if (!primes[i])
				nums[k++] = i;
		for (int i = 4; i < max; ++i)
			psys[i] = isPsycho(i);
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] psychos = new int[n];
			int index = 0;
			for (int i = 0; i < n; ++i) {
				int x = sc.nextInt();
				if (psys[x])
					psychos[index++] = x;
			}
			System.out.println(canWrite(psychos, index, k) ? "YES" : "NO");
		}

	}

	private static boolean canWrite(int[] psychos, int index, int k2) {
		for (int i = 0; i < index; ++i)
			for (int j = i + 1; j < index; ++j)
				if (psychos[i] + psychos[j] == k2)
					return true;
		return false;
	}

	private static boolean isPsycho(int n) {
		if (n < 4)
			return false;
		if (!primes[n])
			return false;
		long evenCount = 0;
		long oddCount = 0;
		long count = 0;
		for (int i = 0; i < k; ++i) {
			long p = nums[i];
			if ((long) p * p > n)
				break;
			count = 0;
			while (n % p == 0) {
				n /= p;
				count++;
			}
			if (count != 0) {
				if (count % 2 == 0)
					evenCount++;
				else
					oddCount++;
			}
		}
		if (n > 1)
			oddCount++;
		// System.out.println(oddCount + " " + evenCount);
		return evenCount > oddCount ? true : false;
	}

}
