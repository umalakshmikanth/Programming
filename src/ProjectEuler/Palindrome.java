package ProjectEuler;

import java.io.*;
import java.util.*;

public class Palindrome {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		System.out.println(s1.length() + s2.length());
		System.out.println(s1.compareTo(s2));

		System.out.println(s1.compareTo(s2) < 0 ? "Yes" : "No");
		System.out.println(cap(s1) + " " + cap(s2));
	//	Arrays.sort()
	}

	private static String cap(String s1) {
		// TODO Auto-generated method stub
		return ((char) (s1.charAt(0) - 32)) + "" + s1.substring(1);
	}

	private static String isGreater(String s1, String s2) {
		// TODO Auto-generated method stub
		if (s1.length() < s2.length())
			return "No";
		for (int i = 0; i < Math.min(s1.length(), s2.length()); ++i)
			if (s1.charAt(i) < s2.charAt(i))
				return "No";
		return "Yes";
	}
}
