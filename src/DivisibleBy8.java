import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class DivisibleBy8 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		ArrayList<String> list = new ArrayList();
		list.add("8");
		list.add("16");
		list.add("24");
		list.add("23");
		list.add("48");
		list.add("04");
		list.add("56");
		list.add("46");
		list.add("27");
		list.add("08");
		list.add("88");
		list.add("69");

		outer: while (t-- > 0) {
			String s = br.readLine();
			if (s.equals("0")) {
				System.out.println("YES");
				continue;
			}
			if (s.length() < 3) {
				String r = sort(s);
				System.out.println(list.contains(r) ? "YES" : "NO");
				continue;
			}
			for (int i = 0; i < s.length(); ++i) {
				for (int j = i + 1; j < s.length(); ++j) {
					for (int k = j + 1; k < s.length(); ++k) {
						if (check(s, i, j, k)) {
							System.out.println("YES");
							continue outer;
						}
					}
				}
			}
			System.out.println("NO");
		}
	}

	private static String sort(String s) {
		// TODO Auto-generated method stub
		if (s.length() == 1)
			return s;
		String r = "";
		return s.charAt(0) > s.charAt(1) ? s.charAt(1) + "" + s.charAt(0) : s;
	}

	private static boolean check(String s, int i, int j, int k) {
		// TODO Auto-generated method stub
		int ans = 0;
		ans = ans * 10 + s.charAt(i) - '0';
		ans = ans * 10 + s.charAt(j) - '0';
		ans = ans * 10 + s.charAt(k) - '0';
		if (ans % 8 == 0)
			return true;
		ans = 0;
		ans = ans * 10 + s.charAt(i) - '0';
		ans = ans * 10 + s.charAt(k) - '0';
		ans = ans * 10 + s.charAt(j) - '0';
		if (ans % 8 == 0)
			return true;
		ans = 0;
		ans = ans * 10 + s.charAt(j) - '0';
		ans = ans * 10 + s.charAt(k) - '0';
		ans = ans * 10 + s.charAt(i) - '0';
		if (ans % 8 == 0)
			return true;
		ans = 0;
		ans = ans * 10 + s.charAt(j) - '0';
		ans = ans * 10 + s.charAt(i) - '0';
		ans = ans * 10 + s.charAt(k) - '0';
		if (ans % 8 == 0)
			return true;
		ans = 0;
		ans = ans * 10 + s.charAt(k) - '0';
		ans = ans * 10 + s.charAt(i) - '0';
		ans = ans * 10 + s.charAt(j) - '0';
		if (ans % 8 == 0)
			return true;
		ans = 0;
		ans = ans * 10 + s.charAt(k) - '0';
		ans = ans * 10 + s.charAt(j) - '0';
		ans = ans * 10 + s.charAt(i) - '0';
		if (ans % 8 == 0)
			return true;
		return false;
	}

}
