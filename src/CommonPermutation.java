import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CommonPermutation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String s1 = sc.nextLine();
			String s2 = sc.nextLine();
			int[] char1 = new int[26];
			int[] char2 = new int[26];

			for (int i = 0; i < s1.length(); ++i) {
				char1[s1.charAt(i) - 'a']++;
			}
			for (int i = 0; i < s2.length(); ++i) {
				char2[s2.charAt(i) - 'a']++;
			}
			ArrayList<Character> list = new ArrayList();
			if (s1.length() < s2.length()) {
				for (int i = 0; i < s1.length(); ++i) {
					if (char2[s1.charAt(i) - 'a'] > 0) {
						list.add(s1.charAt(i));
						char2[s1.charAt(i) - 'a']--;
					}
				}
			} else {
				for (int i = 0; i < s2.length(); ++i) {
					if (char1[s2.charAt(i) - 'a'] > 0) {
						list.add(s2.charAt(i));
						char1[s2.charAt(i) - 'a']--;
					}
				}
			}
			Collections.sort(list);
			String op = "";
			for (char c : list)
				op += c;
			System.out.println(op);
		}
	}

}
