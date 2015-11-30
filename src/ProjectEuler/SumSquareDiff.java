package ProjectEuler;

public class SumSquareDiff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long sum = getSum(100);
		long sqr = getSqr(100);
		System.out.println(sum * sum - sqr);
	}

	private static long getSqr(int i) {
		// TODO Auto-generated method stub
		return (i * (2 * i + 1) * (i + 1)) / 6;
	}

	private static long getSum(int i) {
		// TODO Auto-generated method stub
		return (i * (i + 1)) / 2;
	}

}
