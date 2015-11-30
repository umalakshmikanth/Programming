package ProjectEuler;

public class CoinSums {
	static int max = 207;

	public static void main(String[] args) {
		int[] coins = { 1, 2, 3,4,5,6,7 };
		int[] dp = new int[max];
		dp[0] = 1;
		for (int i = 0; i < coins.length; ++i) {
			int coin = coins[i];
			for (int j = coin; j < max; ++j) {
				dp[j] = dp[j] + dp[j - coin];
			}
		}
		System.out.println(dp[5]);
	}

}
