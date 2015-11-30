package ProjectEuler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LargestExponential {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double max = -1;
		int lineNumber = 0;
		for (int i = 0; i < 1000; ++i) {
			String[] tokens = br.readLine().split(",");
			int a = Integer.parseInt(tokens[0]);
			int b = Integer.parseInt(tokens[1]);
			double x = b * Math.log(a);
			if (x > max) {
				max = x;
				lineNumber = i;
			}
		}
		System.out.println((lineNumber + 1) + " " + max);
	}

}
