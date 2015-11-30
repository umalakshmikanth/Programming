package ProjectEuler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CodedTriangle {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		s = s.replace("\"", "");
		String tokens[] = s.split(",");

		int count = 0;
		for (int i = 0; i < tokens.length; ++i)
			if (isTrian(getAns(tokens[i])))
				count++;
		System.out.println(count);

	}

	private static boolean isTrian(int i) {
		// TODO Auto-generated method stub
		double x = Math.sqrt(8 * i + 1) - 1;
		return x % 2 == 0;
	}

	private static int getAns(String string) {
		// TODO Auto-generated method stub
		int ans = 0;
		for (int i = 0; i < string.length(); ++i)
			ans += string.charAt(i) - 'A' + 1;
		return ans;
	}

}
