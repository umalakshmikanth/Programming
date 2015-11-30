package ProjectEuler;

public class ConsecutivePostivieNumbers {
	static int max = 10000000;
	static int[] arr = new int[max];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 2; i < max; ++i)
			arr[i] = getFacs(i);
		int count = 0;
		for (int i = 1; i < max - 1; ++i)
			if (arr[i] == arr[i + 1]) {
				// System.out.println(i);
				count++;
			}
		System.out.println(count);
	}

	private static int getFacs(int n) {
		// TODO Auto-generated method stub
		int count = 0;
		int ans = 1;
		while (n % 2 == 0) {
			n /= 2;
			count++;
		}
		if (count != 0)
			ans *= (count + 1);
		for (int i = 3; i * i <= n; i += 2) {
			count = 0;
			while (n % i == 0) {
				n /= i;
				count++;
			}
			if (count != 0)
				ans *= (count + 1);
		}
		return n == 1 ? ans : ans * 2;
	}

}
