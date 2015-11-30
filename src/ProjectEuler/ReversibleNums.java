package ProjectEuler;

public class ReversibleNums {
	static int max = 1000000000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 0;
		for (int i = 1; i < max; ++i)
			if (i % 10 != 0 && isRev(i)) {
				count++;
				// System.out.println(i);
			}
		System.out.println(count);
	}

	private static boolean isRev(int i) {
		// TODO Auto-generated method stub
		long sum = i + rev(i);
		return isOddDig(sum);
	}

	private static int rev(int i) {
		// TODO Auto-generated method stub
		int ans = 0;
		while (i > 0) {
			int digit = i % 10;
			ans = ans * 10 + digit;
			i /= 10;
		}
		return ans;
	}

	private static boolean isOddDig(long sum) {
		// TODO Auto-generated method stub
		while (sum > 0) {
			long digit = sum % 10;
			if (digit % 2 == 0)
				return false;
			sum /= 10;
		}
		return true;
	}

}
