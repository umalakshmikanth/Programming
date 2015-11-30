import java.util.ArrayList;
import java.util.Scanner;

public class HappyNumbers {
	static int[] sqrs = new int[10];

	public static void main(String[] args) {
		for (int i = 1; i < 10; ++i)
			sqrs[i] = i * i;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(check(n));
	}

	private static int check(long n) {
		int count = 0;
		long x = getNext(n);
		ArrayList<Long> list = new ArrayList();
		list.add(n);
		while (!list.contains(x)) {
			list.add(x);
			count++;
			if (x == 1)
				return count;
			x = getNext(x);
		}
		return -1;
	}

	private static long getNext(long n) {
		long ans = 0;
		while (n > 0) {
			ans += sqrs[(int) (n % 10)];
			n /= 10;
		}
		return ans;
	}

}
