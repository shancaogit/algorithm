package leetcode;

public class BullsAndCows {
	public String getHint(String secret, String guess) {
		if (secret == null || secret.equals("") || guess == null || guess.equals(""))
			return null;
		int bulls = 0;
		int cows = 0;
		int[] array = new int[10];
		for (int i = 0; i < secret.length(); i++) {
			char sc = secret.charAt(i);
			if (sc == guess.charAt(i)) {
				bulls++;
			} else {
				array[Character.digit(sc, 10)]++;
			}
		}
		for (int i = 0; i < secret.length(); i++) {
			char gc = guess.charAt(i);
			int idx = Character.digit(gc, 10);
			if (secret.charAt(i) != gc && array[idx] > 0) {
				cows++;
				array[idx]--;
			}
		}
		return bulls + "A" + cows + "B";
	}
}
