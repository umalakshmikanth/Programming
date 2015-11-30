package ProjectEuler;

public class LargeNonMernessePrime {
	static long mod = 10000000000L;

	public static void main(String[] args) {
		long val = 1;
		for (int i = 0; i < 7830457; ++i) {
			val = val * 2;
			val %= mod;
		}
		System.out.println(((val * 28433) % mod) + 1) ;
	}

}
