package ProjectEuler;

public class PerfectSquareCollection {
	static int max = 10000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int z = 0; z < max; ++z) {
			for (int y = z + 1; y < max; ++y) {
				for (int x = y + 1; x < max; ++x) {
					if (isPerSqr(x + y) && isPerSqr(x - y) && isPerSqr(x + z) && isPerSqr(x - z) && isPerSqr(y + z)
							&& isPerSqr(y - z))
						System.out.print(x + " " + y + " " + z);

				}
			}
		}
	}

	private static boolean isPerSqr(int i) {
		// TODO Auto-generated method stub
		int x = (int) Math.sqrt(i);
		return x * x == i;
	}

}
