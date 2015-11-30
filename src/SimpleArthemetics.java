import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SimpleArthemetics {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String[] tokens = br.readLine().split("[+\\-*\\/]");
			// System.out.println(tokens[0] + " " + tokens[]);
		}
	}

}
