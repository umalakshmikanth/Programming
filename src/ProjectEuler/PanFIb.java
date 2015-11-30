package ProjectEuler;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public class PanFIb {
	static int max = 1000000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInteger[][] matrix = new BigInteger[2][2];
		matrix[0][0] = new BigInteger("1");
		matrix[0][1] = new BigInteger("1");
		matrix[1][0] = new BigInteger("1");
		matrix[1][1] = new BigInteger("0");

		BigInteger[][] start = matrix;

		for (int i = 0; i < max; ++i) {
			if (check(matrix[0][1])) {
				System.out.println(i);
				break;
			}
			matrix = mul(matrix, start);
		}
	}

	private static boolean check(BigInteger fib) {
		// TODO Auto-generated method stub
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

	private static BigInteger[][] mul(BigInteger[][] a, BigInteger[][] b) {
		BigInteger[][] ans = new BigInteger[2][2];
		ans[0][0] = (a[0][0].multiply(b[0][0])).add(a[0][1].multiply(b[1][0]));
		ans[0][1] = (a[0][0].multiply(b[0][1])).add(a[0][1].multiply(b[1][1]));
		ans[1][0] = a[0][1];
		ans[1][1] = (a[1][0].multiply(b[0][1])).add(a[1][1].multiply(b[1][1]));

		return ans;
	}

}
