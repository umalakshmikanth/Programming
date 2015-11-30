package ProjectEuler;

public class DigitFacs {
	static int max = 100000000;
	static long[] facs = new long[10];

	public static void main(String[] args) {
		long count = 0;
		facs[0] = facs[1] = 1;
		for (int i = 2; i < 10; ++i)
			facs[i] = facs[i - 1] * i;
		for (int i = 3; i < max; ++i) {
			if (getSum(i) == i) {
				System.out.println(i);
				count += i;
			}
		}
		System.out.println(count);

	}

	private static long getSum(int i) {
		// TODO Auto-generated method stub
		long sum = 0;
		while (i > 0) {
			sum += facs[i % 10];
			i /= 10;
		}
		return sum;
	}

}
