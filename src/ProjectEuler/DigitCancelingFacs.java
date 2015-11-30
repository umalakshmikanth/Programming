package ProjectEuler;

public class DigitCancelingFacs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 10; i < 100; ++i) {
			if (i % 10 == 0)
				continue;
			for (int j = i + 1; j < 100; ++j) {
				if (j % 10 == 0)
					continue;
				if (canWrite(i, j))
					System.out.println(i + " " + j);
			}
		}
	}

	private static boolean canWrite(int i, int j) {
		int[] num1 = new int[2];
		int[] num2 = new int[2];
		int k = 0;

		while (i > 0) {
			num1[k++] = i % 10;
			i /= 10;
		}
		k = 0;
		while (j > 0) {
			num1[k++] = j % 10;
			j /= 10;
		}
		for (int x = 0; x < 2; ++x) {
			for (int y = x; y < 2; ++y) {
				if (num1[x] == num2[y])
					num1[x] = num2[y] = -1;
			}
		}
		
		return false;
	}

}
