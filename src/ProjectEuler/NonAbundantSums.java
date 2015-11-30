package ProjectEuler;

import java.util.HashSet;

public class NonAbundantSums {
	static int max = 28123;

	public static void main(String[] args) {
		HashSet<Integer> nums = new HashSet<>();
		for (int i = 0; i < max; ++i) {
			if (getSumFac(i) > i)
				nums.add(i);
		}
		long sum = 0;
		outer: for (int i = 0; i < max; ++i) {
			for (int j : nums) {
				if (nums.contains(i - j))
					continue outer;
			}
			sum += i;
		}
		System.out.println(sum);
	}

	public static int getSumFac(int num) {
		int dup = num;
		if (num < 2)
			return num;
		int ans = 1;
		int count = 0;
		while (num % 2 == 0) {
			count++;
			num /= 2;
		}
		if (count != 0) {
			ans *= ((Math.pow(2, count + 1)) - 1);
		}
		for (int i = 3; i * i <= num; i += 2) {
			count = 0;
			while (num % i == 0) {
				count++;
				num /= i;
			}
			if (count != 0) {
				ans *= (Math.pow(i, count + 1) - 1);
				ans /= (i - 1);
			}
		}
		if (num != 1) {
			ans *= ((Math.pow(num, 2)) - 1);
			ans /= (num - 1);
		}
		return ans - dup;
	}
}
