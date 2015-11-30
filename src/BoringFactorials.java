import java.util.Scanner;

public class BoringFactorials {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int mod = sc.nextInt();
			long fact = 1;
			if (mod <= n)
				System.out.println("0");

			else {
				for (int i = 2; i <= n; ++i) {
					fact *= i;
					fact %= mod;
					if (fact == 0) {
						// System.out.println("0");
						break;
					}
				}
				System.out.println(fact % mod);
			}
		}
	}

}
