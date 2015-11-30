import java.util.Scanner;

public class SimpleArthematics2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			sc.nextLine();
			long ans = sc.nextLong();
			char op = '+';
			while (sc.hasNext()) {
				String s = sc.next();
		//		System.out.println(s);
			//	System.out.println("Case : " + check(s));
				switch (check(s)) {
				case 1:
					ans = get(ans, s, op);
					break;
				case 2:
					op = '+';
					break;
				case 3:
					op = '-';
					break;
				case 4:
					op = '*';
					break;
				case 5:
					op = '/';
					break;
				case 6:
					op = '+';
					System.out.println(ans);
					ans = 0;
					break;
				}
			}
		}
	}

	private static int check(String s) {
		try {
			Long.parseLong(s);
			return 1;
		} catch (Exception e) {

		}
		if (s.equals("+"))
			return 2;
		else if (s.equals("-"))
			return 3;
		else if (s.equals("*"))
			return 4;
		else if (s.equals("/"))
			return 5;
		else
			return 6;
	}

	private static long get(long ans, String s, char op) {
		long x = Long.parseLong(s);
		switch (op) {
		case '+':
			return x + ans;
		case '-':
			return ans - x;
		case '*':
			return ans * x;
		case '/':
			return ans / x;
		}
		return 0	;
	}

}
