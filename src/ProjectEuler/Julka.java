package ProjectEuler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

public class Julka {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			BigInteger n = new BigInteger(sc.next());
			BigInteger y = new BigInteger(sc.next());
			System.out.println(n.add(y).divide(new BigInteger("2")));
			System.out.println(n.subtract(y).divide(new BigInteger("2")));
		}
	}
}
