package leetcode;

/**
 * 1. find first bottom price 2. find first peak price 3. find second bottom
 * price 4. find second peak price 5. while(find <sb, sp> is true) { if (fb < sb
 * ) { if(fp< sp) { fp = sp; } } else { if( sp > fp || (sp-sb) > (fp - fb)) { fp
 * = sb; fp = sp; } } } return fp - fb;
 */
public class BestTimeBuySell {

	public int maxProfit(int[] prices) {
		if (prices == null || prices.length <= 1) {
			return 0;
		}
		int i = 1;
		while (i < prices.length && prices[i - 1] > prices[i]) {
			i++;
		}
		if (i == prices.length)
			return 0;
		int bottom = prices[i - 1];
		int max = 0;
		while (i < prices.length) {
			if (prices[i] <= bottom) {
				bottom = prices[i];
			} else {
				int profit = prices[i] - bottom;
				if (profit > max) {
					max = profit;
				}
			}
			i++;
		}
		return max;
	}
}
