public class SpeedRadar {
	public static void main(String arfs[]) {
		int readings[] = { 10, 20, 30, 40, 50 };
		System.out.println(averageSpeed(10, 50, readings));
	}

	public static double averageSpeed(int minLimit, int maxLimit, int[] readings) {
		int outOfLimit = 0;
		int n = readings.length;
		double sum = 0;
		for (int i = 0; i < n; ++i) {
			if (readings[i] >= minLimit && readings[i] <= maxLimit) {
				sum += readings[i];
			} else
				outOfLimit++;
		}
		if (outOfLimit != 0 && (n * 100) / outOfLimit > 10) {
			System.out.println("outOflimtis");
			return 0.0;
		} else {
			return sum / (double) (n - outOfLimit);
		}
	}
}