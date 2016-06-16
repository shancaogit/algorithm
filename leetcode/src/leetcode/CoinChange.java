package leetcode;

public class CoinChange {
	public int coinChange(int[] coins, int amount) {
		if (coins == null || coins.length == 0 || amount < 0)
			return -1;
		int[] count = new int[amount + 1];
		for (int i = 1; i <= amount; i++) {
			int min = Integer.MAX_VALUE;
			for (int coin : coins) {
				int idx = i - coin;
				if (idx >= 0 && count[idx] != -1 && min > count[idx] + 1) {
					min = count[idx] + 1;
				}
			}
			if (min == Integer.MAX_VALUE) {
				count[i] = -1;
			} else {
				count[i] = min;
			}
		}
		return count[amount];
	}
}
