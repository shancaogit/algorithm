package leetcode;

public class ReverseString {
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
