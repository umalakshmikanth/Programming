import java.util.Scanner;
import java.util.TreeSet;

public class KthLargest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		TreeSet<Integer> set = new TreeSet();
		for (int i = 0; i < k; ++i)
			set.add(sc.nextInt());
		for (int i = k; i < n; ++i) {
			int x = sc.nextInt();
			if (x > set.first()) {
				set.pollFirst();
				set.add(x);
			}
		}
		System.out.println(set.first());
	}

}
