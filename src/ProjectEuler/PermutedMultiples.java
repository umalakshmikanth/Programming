package ProjectEuler;

import java.security.cert.CollectionCertStoreParameters;
import java.util.ArrayList;
import java.util.Collections;

public class PermutedMultiples {
	static int max = 100000000;

	public static void main(String[] args) {
		// TODO Auto-generate d method stub
		for (int i = 1; i < max; ++i)
			if (check(i)) {
				System.out.println(i);

			}
	}

	private static boolean check(int i) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList();
		int x = i;
		while (x > 0) {
			list.add(x % 10);
			x /= 10;
		}
		Collections.sort(list);
		for (int j = 2; j < 7; ++j) {
			x = i * j;
			ArrayList<Integer> list2 = new ArrayList();
			while (x > 0) {
				list2.add(x % 10);
				x /= 10;
			}
			Collections.sort(list2);
			if (!list.equals(list2))
				return false;
		}
		return true;
	}

}
