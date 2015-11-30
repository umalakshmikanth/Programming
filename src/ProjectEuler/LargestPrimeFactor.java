package ProjectEuler;

public class LargestPrimeFactor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getLargestFac(600851475143L));
	}

	private static long getLargestFac(long n) {
		// TODO Auto-generated method stub
		long ans = 0;
		while (n % 2 == 0) {
			n /= 2;
			ans = 2;
			System.out.println("2");
		}
		
		for (long i = 3; (long) i * i <= n; ++i) {
			while (n % i == 0) {
				n /= i;
				ans = i;
				System.out.println(i);
			}
		}
		if (n != 1)
			System.out.println(n);
		return n == 1 ? ans : n;
	}

}
