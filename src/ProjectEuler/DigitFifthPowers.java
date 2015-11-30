package ProjectEuler;

public class DigitFifthPowers {
	static int[] powers = new int[10];
	static int k = 6;
	static int max = 100000000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; ++i)
			powers[i] = (int) Math.pow(i, k);
		int count = 0;
		for (int i = 2; i < max; ++i) {
			if (getSum(i) == i) {
				System.out.println(i);
				count += i;
			}
		}
		System.out.println(count);
	}

	private static int getSum(int i) {
		// TODO Auto-generated method stub
		int sum = 0;
		while (i > 0) {
			sum += powers[i % 10];
			i /= 10;
		}
		return sum;
	}

}
