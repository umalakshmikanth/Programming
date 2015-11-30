import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class PsychoFunction {
	static int max = 3000;
	static boolean[] primes = new boolean[max];
	static int[] nums = new int[max];
	static int k = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 2; i * i < max; ++i)
			if (!primes[i])
				for (int j = i * i; j < max; j += 2)
					primes[j] = true;
		for (int i = 2; i < max; ++i)
			if (!primes[i])
				nums[k++] = i;
		while (t-- > 0) {
			int k = sc.nextInt();
			int b = sc.nextInt();
			int p = sc.nextInt();
			int num = noZeros(k) * getLastDigit(b, p);
			System.out.println(isPsycho(num) ? "Psycho Number" : "Ordinary Number");
		}
	}

	private static boolean isPsycho(int n) {
		if (n < 4)
			return false;
		if (n < max && !primes[n])
			return false;
		long evenCount = 0;
		long oddCount = 0;
		long count = 0;
		for (int i = 0; i < k; ++i) {
			long p = nums[i];
			if ((long) p * p > n)
				break;
			count = 0;
			while (n % p == 0) {
				n /= p;
				count++;
			}
			if (count != 0) {
				if (count % 2 == 0)
					evenCount++;
				else
					oddCount++;
			}
		}
		if (n > 1)
			oddCount++;
		// System.out.println(oddCount + " " + evenCount);
		return evenCount > oddCount ? true : false;
	}

	private static int getLastDigit(int b, int p) {
		// TODO Auto-generated method stub
		BigInteger B = new BigInteger(b + "");
		return B.modPow(new BigInteger(p + ""), new BigInteger("10")).intValue();
	}

	static int noZeros(int n) {
		// Initialize result
		int count = 0;

		// Keep dividing n by powers of 5 and update count
		for (int i = 5; n / i >= 1; i *= 5)
			count += n / i;

		return count;
	}
}
