package ProjectEuler;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class PandigitalFibonacci {
	static int max = 100000;
	static ArrayList<BigInteger[][]> pows;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pows = new ArrayList();
		BigInteger[][] start = new BigInteger[2][2];
		start[0][0] = new BigInteger("1");
		start[0][1] = new BigInteger("1");
		start[1][0] = new BigInteger("1");
		start[1][1] = new BigInteger("0");

		pows.add(start);
		for (int i = 1; i < 22; ++i) {
			pows.add(getPow(pows.get(i - 1)));
			BigInteger[][] ans = pows.get(i);
		}
		System.out.println(fib(540));
		/*
		 * for (int i = 0; i < max; ++i) { if (check(fib(i))) {
		 * System.out.println(i); break; } }
		 */
	}

	private static boolean check(BigInteger fib) {
		String f = fib.toString();
		if (f.length() < 10)
			return false;
		if (isPan(f.substring(f.length() - 9)) && isPan(f.substring(0, 9))) {
			return true;
		}
		return false;
	}

	private static boolean isPan(String f) {
		ArrayList<Integer> list = new ArrayList();
		for (int i = 0; i < f.length(); ++i)
			list.add(f.charAt(i) - '0');
		Collections.sort(list);
		long ans = 0;
		for (int i = 0; i < list.size(); ++i)
			ans = ans * 10 + list.get(i);
		return ans == 123456789;
	}

	private static BigInteger[][] getPow(BigInteger[][] a) {
		// TODO Auto-generated method stub
		BigInteger[][] ans = new BigInteger[2][2];
		ans[0][0] = (a[0][0].multiply(a[0][0])).add(a[0][1].multiply(a[1][0]));
		ans[0][1] = (a[0][0].multiply(a[0][1])).add(a[0][1].multiply(a[1][1]));
		ans[1][0] = (a[1][0].multiply(a[0][0])).add(a[1][1].multiply(a[1][0]));
		ans[1][1] = (a[1][0].multiply(a[0][1])).add(a[1][1].multiply(a[1][1]));

		return ans;
	}

	private static BigInteger fib(int i) {
		// TODO Auto-generated method stub
		BigInteger ans = new BigInteger("0");
		BigInteger[][] matrix = new BigInteger[2][2];
		matrix[0][0] = new BigInteger("1");
		matrix[0][1] = new BigInteger("1");
		matrix[1][0] = new BigInteger("1");
		matrix[1][1] = new BigInteger("0");
		int count = 0;
		while (i > 1) {
			if (i % 2 == 1) {
				matrix = mul(matrix, pows.get(count));
			}
			count++;
			i /= 2;
		}
		matrix = mul(matrix, pows.get(count));
		return matrix[0][1];
	}

	private static BigInteger[][] mul(BigInteger[][] a, BigInteger[][] b) {
		// TODO Auto-generated method stub
		// System.out.println("a : " + a[0][0] + " " + a[0][1] + " " + a[1][0] +
		// " " + a[1][1]);
		// System.out.println("b : " + b[0][0] + " " + b[0][1] + " " + b[1][0] +
		// " " + b[1][1]);

		BigInteger[][] ans = new BigInteger[2][2];
		ans[0][0] = (a[0][0].multiply(b[0][0])).add(a[0][1].multiply(b[1][0]));
		ans[0][1] = (a[0][0].multiply(b[0][1])).add(a[0][1].multiply(b[1][1]));
		ans[1][0] = (a[1][0].multiply(b[0][0])).add(a[1][1].multiply(b[1][0]));
		ans[1][1] = (a[1][0].multiply(b[0][1])).add(a[1][1].multiply(b[1][1]));

		return ans;
	}

}
