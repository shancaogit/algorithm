package leetcode;

public class SelfCrossing {
	public boolean isSelfCrossing(int[] x) {
		if (x.length <= 3)
			return false;
		boolean expand = false;
		if (x[2] > x[0])
			expand = true;
		int i = 3;
		while (i < x.length) {
			if (expand) {
				if (x[i] <= x[i - 2]) {
					i++;
					if (i < x.length) {
						if (x[i - 1] < x[i - 3]) {
							if (i > 4) {
								if (x[i] + x[i - 4] >= x[i - 2] && x[i - 1] + x[i - 5] >= x[i - 3]) {
									return true;
								} else {
									expand = false;
								}
							}
						} else if (x[i - 1] == x[i - 3]) {
							if (x[i] + x[i - 4] >= x[i - 2]) {
								return true;
							} else {
								expand = false;
							}
						}
					}
				}
			} else {
				if (x[i] >= x[i - 2]) {
					return true;
				}
			}
			i++;
		}
		return false;
	}
}
