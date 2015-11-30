package ProjectEuler;

public class DoublebasePalindromes {
	static int max = 1000001;

	public static void main(String[] args) {
		long ans = 0;
		for (int i = 1; i < max; ++i) {
			if (isPalin(i + "")) {
				if (isPalin(Integer.toBinaryString(i))) {
					System.out.println(i);
					ans += i;
				}
			}
		}
		System.out.println(ans);
	}

	private static boolean isPalin(String s) {
		// TODO Auto-generated method stubs
		int len = s.length() - 1;
		for (int i = 0; 2 * i < s.length(); ++i)
			if (s.charAt(i) != s.charAt(len - i))
				return false;
		return true;
	}

}
