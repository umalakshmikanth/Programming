import java.util.Scanner;

public class SharkAnd42 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i = 1;
		while (n > 0) {
			if (i % 2 == 0 ) {
				System.out.println(" n : " + n + " " + i);
				n--;

			}
			i++;
		}
	}

}
