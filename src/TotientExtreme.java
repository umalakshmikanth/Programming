import java.util.Scanner;

public class TotientExtreme {
	static int max = 100007;

	public static void main(String[] args) {
		int[] totient = new int[max];
		for (int i = 1; i < max; ++i) {
			totient[i] = getTotient(i);
		}
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			long h = 0;
			int n = sc.nextInt();
			for (int j = 1; j <= n; ++j) {
				for (int k = 1; k <= n; ++k) {
					h += totient[j] * totient[k];
				}
			}
			System.out.println(h);
		}
	}

	private static int getTotient(int n) {
		int count = n;
		if (n % 2 == 0) {
			count /= 2;
			while (n % 2 == 0)
				n /= 2;
		}
		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0) {
				count++;
				count *= (i - 1);
				count /= i;
				while (n % i == 0)
					n /= i;
			}
		}
		if (n != 1) {
			count *= (n - 1);
			count /= n;
		}
		return count;
	}
}
