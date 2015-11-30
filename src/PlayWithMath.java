import java.util.Scanner;

public class PlayWithMath {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int g = gcd(a, b);
			//System.out.println(b / g + " " + a / g);
			System.out.println(g);
		}
	}

	private static int gcd(int a, int b) {
		// TODO Auto-generated method stub
		return b == 0 ? a : gcd(b, a % b);
	}

}
