import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

public class BestTeam {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println((long) Math.ceil(n * (log(n) + log(log(n)))));
	}

	private static double log(double n) {
		// TODO Auto-generated method stub
		return Math.log(n);
	}
}
