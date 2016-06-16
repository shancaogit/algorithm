package leetcode;

public class NumberOfOneBits {
	public int hammingWeight(int n) {
		int weight = 0;
		while (n != 0) {
			n &= n - 1;
			weight++;
		}
		return weight;
	}
}
