package leetcode;

public class Search2DMatrixII {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0) {
			return false;
		}
		return searchMatrix(matrix, target, 0, 0, matrix.length - 1, matrix[0].length - 1);
	}

	public boolean searchMatrix(int[][] matrix, int target, int startx, int starty, int endx, int endy) {
		if (startx > endx || starty > endy) {
			return false;
		}
		if (startx == endx && starty == endy) {
			return matrix[startx][starty] == target;
		}
		int midx = (startx + endx) / 2;
		int midy = (starty + endy) / 2;
		int middleVal = matrix[midx][midy];
		if (target == middleVal) {
			return true;
		} else if (target > middleVal) {
			if (midx < endx && midy < endy) {
				return searchMatrix(matrix, target, midx + 1, starty, endx, midy)
						|| searchMatrix(matrix, target, startx, midy + 1, midx, endy)
						|| searchMatrix(matrix, target, midx + 1, midy + 1, endx, endy);
			} else if (midx == endx) {
				return searchMatrix(matrix, target, startx, midy + 1, endx, endy);
			} else {
				return searchMatrix(matrix, target, midx + 1, starty, endx, endy);
			}
		} else {
			if (midx < endx && midy < endy) {
				return searchMatrix(matrix, target, startx, starty, midx, midy)
						|| searchMatrix(matrix, target, startx, midy + 1, midx - 1, endy)
						|| searchMatrix(matrix, target, midx + 1, starty, endx, midy - 1);
			} else if (midx == endx) {
				return searchMatrix(matrix, target, startx, starty, endx, midy - 1);
			} else {
				return searchMatrix(matrix, target, startx, starty, midx - 1, endy);
			}
		}
	}
}
