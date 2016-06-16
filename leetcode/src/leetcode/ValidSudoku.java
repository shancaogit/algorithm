package leetcode;

public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		if (board == null || board.length != 9)
			return false;
		for (char[] line : board) {
			if (line == null || line.length != 9)
				return false;
		}
		boolean[][] map = new boolean[27][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				char c = board[i][j];
				if (c >= '1' && c <= '9') {
					int k = (int) c - 49;
					if (map[i][k]) {
						return false;
					} else {
						map[i][k] = true;
					}
					if (map[9 + j][k]) {
						return false;
					} else {
						map[9 + j][k] = true;
					}
					int idx = calculate(i, j);
					if (map[18 + idx][k]) {
						return false;
					} else {
						map[18 + idx][k] = true;
					}
				}
			}
		}
		return true;
	}

	private int calculate(int i, int j) {
		if (i < 3) {
			if (j < 3) {
				return 0;
			} else if (j < 6) {
				return 1;
			} else {
				return 2;
			}
		} else if (i < 6) {
			if (j < 3) {
				return 3;
			} else if (j < 6) {
				return 4;
			} else {
				return 5;
			}
		} else {
			if (j < 3) {
				return 6;
			} else if (j < 6) {
				return 7;
			} else {
				return 8;
			}
		}
	}
}
