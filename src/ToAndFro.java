import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ToAndFro {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;
			String s = br.readLine();
			for (int i = 0; i < s.length(); i += n) {
				System.out.print(s.charAt(i));
			}
		}
	}

}
