import java.util.Arrays;
import java.util.Scanner;

public class SalaryBlue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();
		long[] a = new long[n];
		for (int i = 0; i < n; ++i)
			a[i] = sc.nextInt();
		for (int i = 0; i < q; ++i) {
			int k = sc.nextInt();
			System.out.println(getAddedGCD(a, k));
		}
	}

	private static long getAddedGCD(long[] a, int k) {
		// TODO Auto-generated method stub
		long[] b = new long[a.length];
		for (int i = 0; i < a.length; ++i)
			b[i] = a[i] + k;
	//	System.out.println(Arrays.toString(b));
		return gcd(a);
	}

	private static long gcd(long[] a) {
		// TODO Auto-generated method stub
		long gcd = a[0];
		for (int i = 1; i < a.length; ++i)
			gcd = GCD(gcd, a[i]);
		return gcd;
	}

	private static long GCD(long a, long b) {
		// TODO Auto-generated method stub
		return b == 0 ? a : GCD(b, a % b);
	}

}
