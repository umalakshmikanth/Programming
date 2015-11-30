package ProjectEuler;

public class TriPenthex {
	static int max = 100000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 1; i < max; ++i)
			if (isPent((long) i * (2 * i - 1)))
				System.out.println(i * (2 * i - 1));
	}

	private static boolean isPent(long i) {
		// TODO Auto-generated method stub
		double p = Math.sqrt(24 * i + 1) + 1;
		return p % 6 == 0;

	}

}
