import java.util.Scanner;
import java.util.Stack;

public class CountAndSay {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.println(isValidParentheses(s));

	}

	public static boolean isValidParentheses(String s) {
		Stack<Character> st = new Stack();
		for (int i = 0; i < s.length(); ++i) {
			char ch = s.charAt(i);
			if (ch == ')' || ch == ']' || ch == '}') {
				if (st.isEmpty())
					return false;
				char c = st.pop();
				BigI
				if (c != getCh(ch))
					return false;
			} else {
				st.push(ch);
			}
		}
		if (st.isEmpty())
			return true;
		return false;
	}

	private static char getCh(char c) {
		if (c == ')')
			return '(';
		if (c == ']')
			return '[';
		return '{';
	}
}
