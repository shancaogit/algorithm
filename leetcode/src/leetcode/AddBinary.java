package leetcode;

public class AddBinary {
	public String addBinary(String a, String b) {
		if (a == null || a.equals(""))
			return b;
		if (b == null || b.equals(""))
			return a;
		int alen = a.length();
		int blen = b.length();
		int max = 0;
		int min = 0;
		if (alen > blen) {
			max = alen + 1;
			min = blen;
		} else {
			max = blen + 1;
			min = alen;
		}
		char[] array = new char[max];
		boolean shift = false;
		for (int i = 0; i < min; i++) {
			char ac = a.charAt(alen - 1 - i);
			char bc = b.charAt(blen - 1 - i);
			if (shift) {
				if (ac == '1' && bc == '1') {
					shift = true;
					array[max - 1 - i] = '1';
				} else if (ac == '1' || bc == '1') {
					shift = true;
					array[max - 1 - i] = '0';
				} else {
					shift = false;
					array[max - 1 - i] = '1';
				}
			} else {
				if (ac == '1' && bc == '1') {
					shift = true;
					array[max - 1 - i] = '0';
				} else if (ac == '1' || bc == '1') {
					shift = false;
					array[max - 1 - i] = '1';
				} else {
					shift = false;
					array[max - 1 - i] = '0';
				}
			}
		}
		if (alen > blen) {
			for (int i = blen; i < alen; i++) {
				char ac = a.charAt(alen - 1 - i);
				if (shift) {
					if (ac == '1') {
						array[max - 1 - i] = '0';
					} else {
						shift = false;
						array[max - 1 - i] = '1';
					}
				} else {
					array[max - 1 - i] = ac;
				}
			}
		} else {
			for (int i = alen; i < blen; i++) {
				char bc = b.charAt(blen - 1 - i);
				if (shift) {
					if (bc == '1') {
						array[max - 1 - i] = '0';
					} else {
						shift = false;
						array[max - 1 - i] = '1';
					}
				} else {
					array[max - 1 - i] = bc;
				}
			}
		}
		if (shift)
			array[0] = '1';
		return array[0] == Character.MIN_VALUE ? String.copyValueOf(array, 1, max - 1) : new String(array);
	}
}
