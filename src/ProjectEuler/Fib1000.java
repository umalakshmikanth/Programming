package ProjectEuler;

import java.math.BigInteger;

public class Fib1000 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInteger a = new BigInteger("1");
		BigInteger b = new BigInteger("1");
		BigInteger c = new BigInteger("2");
		int i = 2;
		while (!check(c)) {
			i++;
			c = a.add(b);
			a = b;
			b = c;
			System.out.println(i + " " + c);
		}
		System.out.println(i + " " + c);
	}

	private static boolean check(BigInteger c) {
		// TODO Auto-generated method stub
		String s = c.toString();
		return s.length() == 1000;
	}

}
