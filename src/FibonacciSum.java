import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FibonacciSum {
	static long mod = 1000000007;
	static ArrayList<long[][]> list = new ArrayList();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		long[][] M = { { 1, 1 }, { 1, 0 } };
		long[] fib = { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 };
		list.add(M);
		for (int i = 1; i < 64; ++i) {
			M = squareIt(list.get(i - 1));
			list.add(M);
		}

		while (t-- > 0) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			if (m == 0)
				m++;
			long a = getFib(m + 1);
			long b = getFib(n + 2);
			long ans = (b - a) % mod;
			if(ans < 0)ans += mod;
			System.out.println(ans);
		}
	}

	private static long getFib(int n) {// TODO Auto-generated method stub
		if (n <= 2)
			return 1;
		long ans = 0;
		n -= 2;
		int i = 0;
		long[][] Ans = { { 1, 0 }, { 0, 1 } };
		while (n != 1) {
			if (n % 2 == 1) {
				Ans = multiply(Ans, list.get(i));
				// System.out.println(i);
			}
			i++;
			n /= 2;
		}
		Ans = multiply(Ans, list.get(i));
		return (Ans[0][0] + Ans[0][1]) % mod;
	}

	private static long[][] multiply(long[][] A, long[][] B) {
		// TODO Auto-generated method stub
		long[][] ans = new long[2][2];
		ans[0][0] = ((A[0][0] * B[0][0]) % mod + (A[0][1] * B[1][0]) % mod) % mod;
		ans[0][1] = ((A[0][0] * B[0][1]) % mod + (A[0][1] * B[1][1]) % mod) % mod;
		ans[1][0] = ((A[1][0] * B[0][0]) % mod + (A[1][1] * B[1][0]) % mod) % mod;
		ans[1][1] = ((A[1][0] * B[0][1]) % mod + (A[1][1] * B[1][1]) % mod) % mod;
		return ans;
	}

	private static long[][] squareIt(long[][] m) {
		long[][] matrix = new long[2][2];
		/*
		 * a b a b aa+bc ab+bd c d c d ca+dc cb+dd
		 */
		matrix[0][0] = ((m[0][0] * m[0][0]) % mod + (m[0][1] * m[1][0]) % mod) % mod;
		matrix[0][1] = ((m[0][0] * m[0][1]) % mod + (m[0][1] * m[1][1]) % mod) % mod;
		matrix[1][0] = ((m[1][0] * m[0][0]) % mod + (m[1][1] * m[1][0]) % mod) % mod;
		matrix[1][1] = ((m[1][0] * m[0][1]) % mod + (m[1][1] * m[1][1]) % mod) % mod;

		return matrix;
	}

}
