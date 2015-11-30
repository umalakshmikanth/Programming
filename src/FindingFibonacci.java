import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FindingFibonacci {
	static int mod = 1000000007;
	static ArrayList<long[][]> list = new ArrayList();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		long[][] m = { { 1, 1 }, { 1, 0 } };

		// System.out.println("0 " + m[0][0] + " " + m[0][1] + " " + m[1][0] + "
		// " + m[1][1]);
		list.add(m);
		for (int i = 1; i < 64; ++i) {
			m = squareIt(list.get(i - 1));
			list.add(m);
			// System.out.println(i + " " + m[0][0] + " " + m[0][1] + " " +
			// m[1][0] + " " + m[1][1]);
		}

		while (t-- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int N = sc.nextInt();
			System.out.println(getFib(a, b, N));
		}
	}

	private static long getFib(int a, int b, int n) {
		// TODO Auto-generated method stub
		if (n == 1)
			return b;
		if (n == 2)
			return a + b;

		long ans = 0;
		n--;
		int i = 0;
		long[][] Ans = { { 1, 0 }, { 0, 1 } };
		while (n != 1) {
			if (n % 2 == 1) {
				Ans = multiply(Ans, list.get(i));
		//		System.out.println(i);
			}
			i++;
			n /= 2;
		}
		Ans = multiply(Ans, list.get(i));
		return (Ans[0][0] * b + Ans[0][1] * a) % mod;
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
