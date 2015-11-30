import java.util.Scanner;

public class Javac {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String s = sc.nextLine();
			System.out.println(get(s));
		}
	}

	private static String get(String s) {
		if (s.charAt(0) == '_' || s.charAt(s.length() - 1) == '_')
			return "Error!";
		if (s.charAt(0) < 'a')
			return "Error!";
		if (s.contains("__"))
			return "Error!";
		if (s.contains("_")) {
			if (hasCapital(s))
				return "Error!";
			String ans = "";
			for (int i = 0; i < s.length(); ++i) {
				if (s.charAt(i) == '_') {
					i++;
					ans += (char) (s.charAt(i) - 32);
				} else {
					ans += s.charAt(i);
				}
			}
			if (s.charAt(s.length() - 1) == '_')
				return ans + "_";
			else
				return ans;
		} else {
			String ans = s.charAt(0) + "";
			for (int i = 1; i < s.length(); ++i) {
				if (s.charAt(i) < 'a') {
					ans += "_";
					ans += (char) (s.charAt(i) + 32);
				} else {
					ans += s.charAt(i);
				}
			}
			if (ans.contains("_"))
				return ans.toLowerCase();
			else
				return ans;
		}
	}

	private static boolean hasCapital(String s) {
		for (int i = 0; i < s.length(); ++i)
			if (s.charAt(i) == '_')
				continue;
			else if (s.charAt(i) < 'a')
				return true;
		return false;
	}

}
