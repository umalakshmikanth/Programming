import java.util.Scanner;

public class SpecialMultiple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			getMultiple(n);
		}
	}

	private static void getMultiple(int n) {
		long ans = 1;
		for (int i = 1; i < Long.MAX_VALUE; ++i) {
			String s = Long.toBinaryString(i);
			if (check(n, s)) {
				System.out.println(s.replace("1", "9"));
				return;
			}
		}
	}

	private static boolean check(int n, String s) {
		// TODO Auto-generated method stub
		s = s.replace("1", "9");
		long l = Long.parseLong(s);
		return l % n == 0;
	}

}
