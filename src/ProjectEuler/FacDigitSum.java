package ProjectEuler;

import java.math.BigInteger;

public class FacDigitSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInteger b = new BigInteger("1");
		for (int i = 2; i <= 100; ++i) {
			b = b.multiply(new BigInteger(i + ""));
		}
		while (b.mod(new BigInteger("10")).toString().equals("0"))
			b = b.divide(new BigInteger("10"));
		String s = b.toString();
		long sum = 0;
		for (int i = 0; i < s.length(); ++i)
			sum += s.charAt(i) - '0';
		System.out.println(sum);
	}

}
