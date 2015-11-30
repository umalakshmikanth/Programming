import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class NFactorful {
	static int max = 1000;
	static boolean[] primes = new boolean[max];
	static int[] nums = new int[max];
	static int k = 0;
	static int MAX = 1000000;

	public static void main(String[] args) {
		for (int i = 2; i * i < max; ++i)
			if (!primes[i])
				for (int j = i * i; j < max; j += i)
					primes[j] = true;
		for (int i = 2; i < max; ++i)
			if (!primes[i])
				nums[k++] = i;
		HashMap<Integer, ArrayList<Integer>> hm = new HashMap<Integer, ArrayList<Integer>>();
		for (int i = 1; i < 11; ++i) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			hm.put(i, list);
		}
		for (int i = 2; i < MAX; ++i) {
			int x = getFacs(i);
			if (x <= 10) {
				ArrayList<Integer> list = hm.get(x);
				list.add(i);
				hm.put(x, list);
			}
		}
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int n = sc.nextInt();
			if (n == 0) {
				System.out.println("1");
				continue;
			}
			ArrayList<Integer> list = hm.get(n);
			int count = 0;
//			System.out.println(n + " " + list);
			for (int i : list) {
				if (i >= a && i <= b)
					count++;
				if (i > b)
					break;
			}
			System.out.println(count);
		}
	}

	private static int getFacs(int n) {
		// TODO Auto-generated method stub
		if (n < 3)
			return 1;
		int count = 0;
		for (int i = 0; i < k; ++i) {
			int p = nums[i];
			if (p * p > n)
				break;
			boolean div = false;
			while (n % p == 0) {
				div = true;
				n /= p;
			}
			if (div)
				count++;
		}

		return n == 1 ? count : count + 1;
	}

}
