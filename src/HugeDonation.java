import java.util.ArrayList;
import java.util.Scanner;

public class HugeDonation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long max = 1000000000000000000L;
		ArrayList<Long> list = new ArrayList();
		long x = 0;
		int i = 1;
		long[] arr = new long[1442250];
		while (x < max) {
			list.add(x);
			x += (long) i * i;
			arr[i - 1] = x;
			i++;
		}/*
		for (i = 0; i < 20; ++i)
			System.out.print(arr[i] + " ");*/
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int low = 0;
			int high = arr.length - 1;
			x = sc.nextLong();
			while (low < high) {
				int mid = (low + high) / 2;
				assert(mid < high);
				long d1 = Math.abs(arr[mid] - x);
				long d2 = Math.abs(arr[mid + 1] - x);
				if (d2 <= d1) {
					low = mid + 1;
				} else {
					high = mid;
				}
			}
			System.out.println(arr[high] <= x ?  (high + 1) : high);
		}
	}
}
