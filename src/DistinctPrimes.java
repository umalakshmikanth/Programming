import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class DistinctPrimes {
	static int max = 5000;
	static ArrayList<Integer> set = new ArrayList();

	public static void main(String[] args) {
		for (int i = 30; i < max; ++i) {
			if (noOfFacs(i) >= 3) {
				set.add(i);
			//	System.out.println(i);
				if (set.size() > 1007)
					break;
			}
		}
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			System.out.println(set.get(n - 1));
		}

	}

	private static int noOfFacs(int n) {
		int count = 0;
		if (n % 2 == 0) {
			count++;
			while (n % 2 == 0)
				n /= 2;
		}
		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0) {
				count++;
			}
			while (n % i == 0)
				n /= i;
		}
		return n == 1 ? count : count + 1;
	}

}
