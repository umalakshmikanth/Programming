package ProjectEuler;

public class IntegerRightTriangles {
	static int max = 5000000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] x = new int[max];
		for (int a = 3; a < max / 3; ++a) {
			for (int b = a + 1; b < max / 2; ++b) {
				int c2 = a * a + b * b;
				if (isSqr(c2)) {
					int c = (int) Math.sqrt(c2);
					if (c > b && (a + b + c) < max)
						x[a + b + c]++;
				}
			}
		}
		int best = -1;
		int bestp = 0;
		for (int i = 0; i < max; ++i) {
			if (x[i] > best) {
				best = x[i];
				bestp = i;
			}
		}
		System.out.println(bestp);
	}

	private static boolean isSqr(int i) {
		// TODO Auto-generated method stub
		int p = (int) Math.sqrt(i);
		return p * p == i;
	}

}
