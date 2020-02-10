package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class ZombieMatrix {

    public static void main(String[] args) {
        int[][] grid = {{0, 1, 1, 0, 1}, {0, 1, 0, 1, 0}, {0, 0, 0, 0, 1}, {0, 1, 0, 0, 0}};
        System.out.println(minhours_dps(grid));
        System.out.println(minhours(grid));
    }

    private static int minhours_dps(int[][] grid) {
        int total = grid.length * grid[0].length;
        int zombies = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    zombies++;
                    queue.add(new int[]{i, j});
                }
            }
        }
        int h = 0;
        Queue<int[]> effectionQueue = new LinkedList<>();
        while (!queue.isEmpty() || !effectionQueue.isEmpty()) {
            if(zombies == total) return h;
            h++;
            if (!queue.isEmpty()) {
                while (!queue.isEmpty()) {
                    int[] zombie = queue.poll();
                    int i = zombie[0];
                    int j = zombie[1];
                    if (i > 0 && grid[i - 1][j] == 0) {
                        grid[i - 1][j] = 1;
                        effectionQueue.add(new int[]{i - 1, j});
                        zombies++;
                    }
                    if (j > 0 && grid[i][j - 1] == 0) {
                        grid[i][j - 1] = 1;
                        effectionQueue.add(new int[]{i, j - 1});
                        zombies++;
                    }
                    if (i < grid.length - 1 && grid[i + 1][j] == 0) {
                        grid[i + 1][j] = 1;
                        effectionQueue.add(new int[]{i + 1, j});
                        zombies++;
                    }
                    if (j < grid[0].length - 1 && grid[i][j + 1] == 0) {
                        grid[i][j + 1] = 1;
                        effectionQueue.add(new int[]{i, j + 1});
                        zombies++;
                    }
                }

            } else if (!effectionQueue.isEmpty()) {
                while (!effectionQueue.isEmpty()) {
                    int[] zombie = effectionQueue.poll();
                    int i = zombie[0];
                    int j = zombie[1];
                    if (i > 0 && grid[i - 1][j] == 0) {
                        grid[i - 1][j] = 1;
                        queue.add(new int[]{i - 1, j});
                        zombies++;
                    }
                    if (j > 0 && grid[i][j - 1] == 0) {
                        grid[i][j - 1] = 1;
                        queue.add(new int[]{i, j - 1});
                        zombies++;
                    }
                    if (i < grid.length - 1 && grid[i + 1][j] == 0) {
                        grid[i + 1][j] = 1;
                        queue.add(new int[]{i + 1, j});
                        zombies++;
                    }
                    if (j < grid[0].length - 1 && grid[i][j + 1] == 0) {
                        grid[i][j + 1] = 1;
                        queue.add(new int[]{i, j + 1});
                        zombies++;
                    }
                }

            }
        }

        return h;

    }

    private static int minhours(int[][] grid) {
        int leftPersons = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    leftPersons++;
                }
            }
        }
        int h = 0;
        int[][] count = new int[grid.length][grid[0].length];
        while (leftPersons > 0) {
            h++;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1 && count[i][j] < h) {
                        count[i][j]++;
                        if (i > 0 && grid[i - 1][j] == 0) {
                            grid[i - 1][j] = 1;
                            count[i - 1][j]++;
                            leftPersons--;
                        }
                        if (j > 0 && grid[i][j - 1] == 0) {
                            grid[i][j - 1] = 1;
                            count[i][j - 1]++;
                            leftPersons--;
                        }
                        if (i < grid.length - 1 && grid[i + 1][j] == 0) {
                            grid[i + 1][j] = 1;
                            count[i + 1][j]++;
                            leftPersons--;
                        }
                        if (j < grid[0].length - 1 && grid[i][j + 1] == 0) {
                            grid[i][j + 1] = 1;
                            count[i][j + 1]++;
                            leftPersons--;
                        }
                    }
                }
            }
        }
        return h;
    }

}
