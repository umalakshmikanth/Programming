package ProjectEuler;

import java.util.Scanner;

public class UglyNumbers {
	static int max = 100000007;
	static boolean[] ans = new boolean[max];

	public static void main(String[] args) {
		int a[] = { 2, 3, 5 };
		ans[1] = true;
		for (int i = 0; i < a.length; ++i)
			for (int j = a[i]; j < max; j += a[i])
				ans[j] = true;
		int[] nums = new int[max];
		int k = 0;
		for (int i = 0; i < max; ++i)
			if (ans[i]) {
				nums[k++] = i;
			}
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			System.out.println(nums[n - 1]);
		}
	}

}
