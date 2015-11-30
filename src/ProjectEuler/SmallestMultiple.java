package ProjectEuler;

public class SmallestMultiple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long lcm = 1;
		for (long i = 2; i < 21; ++i)
			lcm = getLcm(lcm, i);
		System.out.println(lcm);
	}
	

	private static long getLcm(long lcm, long b) {
		// TODO Auto-generated method stub
		long prod = lcm * b;
		return prod / gcd(lcm, b);
	}

	private static long gcd(long lcm, long b) {
		// TODO Auto-generated method stub
		return b == 0 ? lcm : gcd(b, lcm % b);
	}

}
