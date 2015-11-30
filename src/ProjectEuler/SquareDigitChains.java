package ProjectEuler;

public class SquareDigitChains {
	static int max = 10000000;
	static boolean[] mat = new boolean[max + 1];
	static int[] squares = new int[10];

	public static void main(String[] args) {
		int count = 0;
		long stime = System.currentTimeMillis();
		for (int i = 1; i < 10; ++i)
			squares[i] = i * i;
		for (int i = 2; i <= max; ++i) {
			if (canWrite(i)) {

				// System.out.println(i);
				count++;
			}
		}
		System.out.println(count + " " + (System.currentTimeMillis() - stime));
	}

	private static boolean canWrite(int n) {
		int i = n;
		while (n != 89) {
			if (n > max)
				return false;
			if (mat[n]) {
				mat[i] = true;
				return true;
			}
			n = getNum(n);
			if (n == 1) {
				mat[i] = false;
				return false;
			}
		}
		return true;
	}

	private static int getNum(int n) {
		int sum = 0;
		while (n > 0) {
			sum += squares[n % 10];
			n /= 10;
		}
		return sum;
	}

}
