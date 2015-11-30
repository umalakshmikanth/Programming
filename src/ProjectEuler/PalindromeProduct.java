package ProjectEuler;

import java.util.ArrayList;

public class PalindromeProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int prod = 0;
		for (int i = 999; i >= 100; --i) {
			for (int j = 999; j >= 100; --j) {
				int p = i * j;
				if (isPalin(p))
					{
					if(p > prod)
						prod = p;
					}
			}
		}
		System.out.println(prod);
	}

	private static boolean isPalin(int i) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList();
		int dup = i;
		while (i > 0) {
			list.add(i % 10);
			i /= 10;
		}
		int ans = 0;
		for (i = 0; i < list.size(); ++i)
			ans = ans * 10 + list.get(i);
		return dup == ans;
	}

}
