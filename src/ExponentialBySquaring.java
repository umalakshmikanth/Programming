import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class ExponentialBySquaring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long x = sc.nextLong();
		System.out.println(getPow(n, x));
	}

	private static BigInteger getPow(long N, long n) {
		// TODO Auto-generated method stub
		BigInteger ans = new BigInteger("1");
		BigInteger[] vals = new BigInteger[32];
		vals[0] = new BigInteger(String.valueOf(N));
		for (int i = 1; i < 20; ++i)
			vals[i] = vals[i - 1].multiply(vals[i - 1]);
		// System.out.println(Arrays.toString(vals));
		int i = 0;
		while (n != 1) {
			if (n % 2 == 1) {
				ans = ans.multiply(vals[i]);
				System.out.println("vals[" + i + "] * ");
			}
			n = n / 2;
			i++;
		}
		System.out.println("vals[" + i + "] * ");
		return ans.multiply(vals[i]);
	}

}
