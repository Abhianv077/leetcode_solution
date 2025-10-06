import java.util.*;

class Solution {
    private static final int[][] directions = {
        {-1, 0}, {0, -1}, {1, 0}, {0, 1}
    };

    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, k});

        boolean[][][] visited = new boolean[m][n][k + 1];
        visited[0][0][k] = true;

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int s = 0; s < size; s++) {
                int[] curr = queue.poll();
                int i = curr[0], j = curr[1], obs = curr[2];

                if (i == m - 1 && j == n - 1) {
                    return steps;
                }

                for (int[] dir : directions) {
                    int newI = i + dir[0];
                    int newJ = j + dir[1];

                    if (newI < 0 || newI >= m || newJ < 0 || newJ >= n)
                        continue;

                    if (grid[newI][newJ] == 0 && !visited[newI][newJ][obs]) {
                        queue.offer(new int[]{newI, newJ, obs});
                        visited[newI][newJ][obs] = true;
                    } else if (grid[newI][newJ] == 1 && obs > 0 && !visited[newI][newJ][obs - 1]) {
                        queue.offer(new int[]{newI, newJ, obs - 1});
                        visited[newI][newJ][obs - 1] = true;
                    }
                }
            }
            steps++;
        }

        return -1;
    }
}
