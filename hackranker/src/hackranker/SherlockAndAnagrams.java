package hackranker;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SherlockAndAnagrams {
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();
		for (int n_i = 0; n_i < n; n_i++) {
			String a = in.nextLine();
			Map<String, Integer> map = new HashMap<>();
			for (int i = 0; i < a.length(); i++) {
				int[] letters = new int[26];
				for (int j = i; j < a.length(); j++) {
					letters[a.charAt(j) - 97]++;
					StringBuilder sb = new StringBuilder();
					for (int k = 0; k < 26; k++) {
						if (letters[k] != 0) {
							sb.append((char) (k + 97) + "" + letters[k]);
						}
					}
					String str = sb.toString();
					if (map.containsKey(str)) {
						map.put(str, map.get(str) + 1);
					} else {
						map.put(str, 1);
					}
				}
			}
			long result = 0;
			for (Integer val : map.values()) {
				if (val > 1) {
					result = result + val * (val - 1) / 2;
				}
			}
			System.out.println(result);
		}
		in.close();
	}
}
