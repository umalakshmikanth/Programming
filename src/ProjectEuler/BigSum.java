package ProjectEuler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BigSum {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BigInteger sum = new BigInteger("0");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = "", x;

		while ((x = br.readLine()) != null && x.length() != 0) {
			sum = sum.add(new BigInteger(x));
		}
		System.out.println(sum.toString().substring(0, 10));
	}

}
