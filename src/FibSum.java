import java.util.Arrays;
import java.util.Scanner;

public class FibSum {
	static int max = 1000000000;
	static int mod = 1000000007;

	public static void main(String[] args) {
		int[] fibSum = new int[max];
		fibSum[0] = 0;
		fibSum[1] = 1;

		int a = 0, b = 1;
		int c = a + b;
		for (int i = 2; i < max; ++i) {
			fibSum[i] = (fibSum[i - 1] + c) % mod;
			a = b;
			b = c;
			c = (a + b) % mod;
		}
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			if (m == 0)
				m++;
			int ans = (fibSum[n] - fibSum[m - 1]);
			if (ans < 0)
				ans += mod;
			System.out.println(ans);
		}
	}

}
