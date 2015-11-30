
public class BouncyNumbers {
	static int max = 100000000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 0;
		int per = 99;
		for (int i = 1; i <= max; ++i) {
			if (isBouncy(i)) {
				count++;
				if ((count * 100) / i == per) {
					System.out.println(i);
					break;
				}
			}
		}
	}

	private static boolean isBouncy(int i) {
		// TODO Auto-generated method stub
		if (!isInc(i) && !isDec(i))
			return true;
		return false;
	}

	private static boolean isDec(int i) {
		// TODO Auto-generated method stub
		int num = i % 10;
		i /= 10;
		while (i > 0) {
			if ((i % 10) < num)
				return false;
			num = i % 10;
			i /= 10;
		}
		return true;
	}

	private static boolean isInc(int i) {
		// TODO Auto-generated method stub
		int num = i % 10;
		i /= 10;
		while (i > 0) {
			if (i % 10 > num)
				return false;
			num = i % 10;
			i /= 10;
		}
		return true;
	}

}
