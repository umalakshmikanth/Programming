import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

public class PoweredAndSquared {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String[] a = br.readLine().split(" ");
			System.out.println(getAns(a[0], a[1], a[2]));
		}
	}

	private static BigInteger getAns(String a, String b, String c) {
		BigInteger A = new BigInteger(a);
		BigInteger B = getB(b);
		BigInteger C = new BigInteger(c);
		//System.out.println(B);
		return A.modPow(B, C);
	}

	private static BigInteger getB(String b) {
		BigInteger ans = new BigInteger("0");
		BigInteger x = new BigInteger("1");

		for (int i = b.length() - 1; i >= 0; --i) {
			BigInteger B = new BigInteger((b.charAt(i) - '0' + "")).multiply(x);
			ans = ans.add(B);
			x = x.multiply(new BigInteger("3"));
		}
		return ans;
	}

}
