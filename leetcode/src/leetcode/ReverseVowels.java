package leetcode;

import java.util.Arrays;
import java.util.List;

public class ReverseVowels {

	public String reverseVowels(String s) {
		if (s == null || s.length() <= 1)
			return s;
		List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
		char array[] = new char[s.length()];
		int l = 0;
		int r = s.length() - 1;
		while (l <= r) {
			while (l < r && !vowels.contains(s.charAt(l))) {
				array[l] = s.charAt(l);
				l++;
			}
			while (l < r && !vowels.contains(s.charAt(r))) {
				array[r] = s.charAt(r);
				r--;
			}
			if (l <= r) {
				array[l] = s.charAt(r);
				array[r] = s.charAt(l);
				l++;
				r--;
			}
		}
		return new String(array);
	}
	
	public String reverseString(String s) {
		if (s == null || s.length() <= 1)
			return s;
		char array[] = new char[s.length()];
		for (int i = 0; i < s.length(); i++) {
			array[s.length() - 1 - i] = s.charAt(i);
		}
		return new String(array);
	}
}
