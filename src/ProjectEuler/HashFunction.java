package ProjectEuler;

import java.io.*;
import java.util.*;

public class HashFunction {
	static int mod = 10007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = null;
		HashMap<String, Long> hm1 = new HashMap();
		HashMap<String, Long> hm2 = new HashMap();
		TreeMap<Long, ArrayList<String>> map = new TreeMap();
		while ((s = br.readLine()) != null && s.length() != 0) {
			String[] tokens = s.split("\\s+");
			long key1 = hashFunction(tokens[0]);
			long key2 = hashFunction(tokens[1]);

			hm1.put(tokens[0], hashFunction(tokens[0]));
			hm2.put(tokens[1], hashFunction(tokens[1]));

			if (!map.containsKey(key2)) {
				ArrayList<String> list = new ArrayList();
				list.add(tokens[1]);
				map.put(key2, list);
			} else {
				map.get(key2).add(tokens[1]);
			}
			if (!map.containsKey(key1)) {
				ArrayList<String> list = new ArrayList();
				list.add(tokens[0]);
				map.put(key1, list);
			} else {
				map.get(key1).add(tokens[0]);
			}

		}
		System.out.println(hm1);
		System.out.println(hm2);
		System.out.println(map);

		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			if (((ArrayList<String>) pair.getValue()).size() == 2)
				System.out.println(pair.getValue());
		}
	}

	private static Long hashFunction(String word) {
		long hash = 5831;
		for (int i = 0; i < word.length(); ++i) {
			hash *= 33;
			hash %= mod;
			hash += word.charAt(i);
			hash %= mod;
		}
		return hash;
	}

}
