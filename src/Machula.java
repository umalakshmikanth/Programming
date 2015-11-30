import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Machula {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			br.readLine();
			String[] tokens = br.readLine().split(" ");
			System.out.println(getAns(tokens[0], tokens[2], tokens[4]));
			
		}

	}

	private static String getAns(String a, String b, String c) {
		String ans = "";
		if (a.contains("machula")) {
			a = (Integer.parseInt(c) - Integer.parseInt(b)) + "";
		} else if (b.contains("machula")) {
			b = (Integer.parseInt(c) - Integer.parseInt(a)) + "";
		} else {
			c = (Integer.parseInt(a) + Integer.parseInt(b)) + "";
		}
		return a + " + " + b + " = " + c;
	}

}
