package ProjectEuler;

import java.security.cert.CollectionCertStoreParameters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class PrimePermutations {
	static int max = 10000;

	public static void main(String[] args) {
		boolean[] primes = new boolean[max];
		for (int i = 2; i * i < max; ++i)
			if (!primes[i])
				for (int j = i * i; j < max; j += i)
					primes[j] = true;
		int[] nums = new int[max];
		int k = 0;
		TreeMap<Integer, ArrayList<Integer>> set = new TreeMap<>();
		for (int i = 1000; i < max; ++i)
			if (!primes[i]) {
				nums[k++] = i;
				int num = getSorted(i);
				if (!set.containsKey(num)) {
					set.put(num, new ArrayList<Integer>(i));
				} else {
					ArrayList<Integer> list = set.get(num);
					list.add(i);
					set.put(num, list);
				}
			}
		Iterator it = set.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			ArrayList<Integer> list = (ArrayList<Integer>) pair.getValue();
			for (int i = 0; i < list.size(); ++i) {
				for (int j = i + 1; j < list.size(); ++j) {
					int d = list.get(j) - list.get(i);
					if (list.contains(list.get(j) + d))
						System.out.println(list.get(i) + " " + list.get(j) + " " + (list.get(j) + d));
				}
			}
		}
	}

	private static int getSorted(int i) {
		ArrayList<Integer> nums = new ArrayList();
		while (i > 0) {
			nums.add(i % 10);
			i /= 10;
		}
		Collections.sort(nums);
		int n = 0;
		for (i = nums.size() - 1; i >= 0; --i)
			n = n * 10 + nums.get(i);
		return n;
	}

}
