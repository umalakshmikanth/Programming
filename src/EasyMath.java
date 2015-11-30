import java.math.BigInteger;
import java.util.Scanner;

public class EasyMath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			System.out.println(getSum(getAns(n)));
		}
	}

	private static int getSum(String x) {
		// TODO Auto-generated method stub
		int a = 0, b = 0;
		for (int i = 0; i < x.length(); i++)
			if (x.charAt(i) - '0' == 1)
				a++;
			else
				b++;

		return 2 * a + b;
	}

	private static String getAns(int n) {
		// TODO Auto-generated method stub
		long ans = 0;
		if (4 % n == 0)
			return "1";
		long i = 2;
		String s = "";
		for (; i < Long.MAX_VALUE; i += 2) {
			s = Long.toBinaryString(i);
			if (check(s, n)) {
				System.out.println(s.replace("1", "4"));
				break;
			}
		}

		return s;
	}

	private static boolean check(String s, int n) {
		s = s.replace("1", "4");
		BigInteger b = new BigInteger(s);
		return (b.mod(new BigInteger(n + "")).toString().equals("0"));
	}

}
