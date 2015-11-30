import java.math.BigInteger;

public class Problem {

	public static void main(String[] args) {
		BigInteger x = new BigInteger("1");
		for (int i = 1; i < 62; ++i) {
			if (x.mod(new BigInteger("10")).toString().equals("0"))
				System.out.println(x);
			x = x.multiply(new BigInteger("4"));
		}
	}

}
