import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] f = new int[72];
		f[0] = f[1] = 1;
		for (int i = 2; i < 72; ++i)
			f[i] = f[i - 1] + f[i - 2];
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while (t-- > 0) {
			System.out.println(f[s.nextInt() - 1]);
		}
	}

}
