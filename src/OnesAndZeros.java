import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class OnesAndZeros {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			if (isBinary(n)) {
				System.out.println(n);
			} else {
				System.out.println(getAns(n));
			}
		}
	}

	private static String getAns(int n) {
		String s = "";
		BigInteger N = new BigInteger(n + "");
		for (long i = 1; i < Long.MAX_VALUE; ++i) {
			s = Long.toBinaryString(i);
			BigInteger b = new BigInteger(s);
			if (b.mod(N).longValue() == 0)
				return s;
		}
		return s;
	}

	private static boolean isBinary(int n) {
		while (n > 0) {
			if (n % 10 > 1)
				return false;
			n /= 10;
		}
		return true;
	}

}
