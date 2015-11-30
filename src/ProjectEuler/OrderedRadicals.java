package ProjectEuler;

import java.util.*;

public class OrderedRadicals {
	static int max = 100000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i = 1; i <= max; ++i) {
			hm.put(i, getVal(i));
		}
		LinkedHashMap<Integer, Integer> m = sortHashMapByValuesD(hm);
		Iterator it = m.entrySet().iterator();
		int count = 0;
		int N = 10000;
		while (it.hasNext()) {
			count++;
			Map.Entry pair = (Map.Entry) it.next();
			if (count == N)
				System.out.println(pair.getKey());

			// System.out.println(pair.getKey() + " = " + pair.getValue());
		}
	}

	private static int getVal(int num) {
		// TODO Auto-generated method stub
		int ans = 1;
		boolean div = false;
		while (num % 2 == 0) {
			div = true;
			num /= 2;
		}
		if (div)
			ans *= 2;
		for (int i = 3; i * i <= num; ++i) {
			div = false;
			while (num % i == 0) {
				div = true;
				num /= i;
			}
			if (div)
				ans *= i;
		}
		return num == 1 ? ans : ans * num;
	}

	public static LinkedHashMap<Integer, Integer> sortHashMapByValuesD(HashMap<Integer, Integer> passedMap) {
		List<Integer> mapKeys = new ArrayList<Integer>(passedMap.keySet());
		List<Integer> mapValues = new ArrayList<Integer>(passedMap.values());
		Collections.sort(mapValues);
		Collections.sort(mapKeys);

		LinkedHashMap<Integer, Integer> sortedMap = new LinkedHashMap<Integer, Integer>();

		Iterator<Integer> valueIt = mapValues.iterator();
		while (valueIt.hasNext()) {
			Integer val = valueIt.next();
			Iterator<Integer> keyIt = mapKeys.iterator();

			while (keyIt.hasNext()) {
				Object key = keyIt.next();
				Integer comp1 = passedMap.get(key);
				Integer comp2 = val;

				if (comp1.equals(comp2)) {
					passedMap.remove(key);
					mapKeys.remove(key);
					sortedMap.put((Integer) key, (Integer) val);
					break;
				}

			}

		}
		return sortedMap;
	}
}
