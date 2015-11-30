import java.util.Scanner;

public class MaximumSubArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] a = new int[n];
		a[0] = sc.nextInt();
		for (int i = 1; i < n; ++i)
			a[i] = a[i - 1] + sc.nextInt();
		long bestSum = 0;
		for (int i = n - 1; i >= 0; --i)
			for (int j = 0; j < i; ++j)
				if (a[i] - a[j] <= k && a[i] - a[j] > bestSum)
					bestSum = a[i] - a[j];
		System.out.println(bestSum);
	}
}
