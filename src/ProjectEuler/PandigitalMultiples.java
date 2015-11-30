package ProjectEuler;

import java.util.Arrays;

public class PandigitalMultiples {
	static int max = 1000000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k = 9;
		for (int i = 1; i < max; ++i) {
			String s = "";
			for (int j = 1; j < k; ++j) {
				s += (i * j);
				if (s.length() > 9)
					break;
				if (isPan(s))
					System.out.println(i + " " + s);
			}
		}
	}

	private static boolean isPan(String s) {
		char[] a = s.toCharArray();
		Arrays.sort(a);
		String p = new String(a);
		return p.equals("123456789");
	}

}
