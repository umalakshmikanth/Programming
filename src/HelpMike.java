import java.util.Scanner;

public class HelpMike {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int N = sc.nextInt();
			int k = sc.nextInt();
			int n = (N - 1) / k;
			long ans = ((k * n) * ((n + 1)) + 2 * n) / 4;
			System.out.println(ans + 2);
		}
	}

}
