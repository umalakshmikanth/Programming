import java.util.Scanner;

public class WillStopOrNot {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		System.out.println(isPow2(n) ? "TAK" : "NIE");
	}

	private static boolean isPow2(long n) {
		while (n % 2 == 0)
			n /= 2;
		return n == 1;
	}
}
