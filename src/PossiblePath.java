import java.util.HashSet;
import java.util.Scanner;

public class PossiblePath {
	static long c, d;
	static HashSet<String> set;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			long a = sc.nextLong();
			long b = sc.nextLong();
			c = sc.nextLong();
			d = sc.nextLong();
			System.out.println(gcd(a, b) == gcd(c, d) ? "YES" : "NO");

		}
	}

	private static long gcd(long a, long b) {
		// TODO Auto-generated method stub
		return b == 0 ? a : gcd(b, a % b);
	}

}
