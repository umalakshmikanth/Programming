package ProjectEuler;

import java.math.BigInteger;

public class ConcealedSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (long i = 1000000000; i < Long.MAX_VALUE; i += 10) {
			String s = new BigInteger(i + "").pow(2).toString();
			if (s.length() > 19)
				break;
			if (s.length() == 19)
				if (check(s)) {
					System.out.println(i + " " + s);
					break;
				}
		}
	}

	private static boolean check(String s) {
		// TODO Auto-generated method stub
		if (s.charAt(0) == '0' && s.charAt(2) == '1' && s.charAt(4) == '2' && s.charAt(6) == '3' && s.charAt(8) == '4'
				&& s.charAt(10) == '5' && s.charAt(12) == '6' && s.charAt(14) == '7' && s.charAt(16) == '8'
				&& s.charAt(18) == '9')
			return true;
		return false;
	}

}
