package hackranker;

import java.util.Scanner;

public class MaximizingXOR {
	static int maxXor(int l, int r) {
		String sl = Integer.toBinaryString(l);
		String sr = Integer.toBinaryString(r);

		if (sr.length() > sl.length()) {
			return (1 << sr.length()) - 1;
		} else {
			int len = 0;
			for (int i = 1; i < sr.length(); i++) {
				if (sl.charAt(i) != sr.charAt(i)) {
					len = sr.length() - i;
					break;
				}
			}
			return (1 << len) - 1;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int res;
		int _l;
		_l = Integer.parseInt(in.nextLine());

		int _r;
		_r = Integer.parseInt(in.nextLine());

		res = maxXor(_l, _r);
		System.out.println(res);
		in.close();
	}
}
