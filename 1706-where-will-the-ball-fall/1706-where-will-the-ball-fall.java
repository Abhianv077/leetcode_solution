import java.util.*;

class Solution {
    public int[] findBall(int[][] grid) {
        int m = grid.length;       // rows
        int n = grid[0].length;    // columns
        int[] result = new int[n];

        for (int ball = 0; ball < n; ball++) {
            int row = 0;
            int col = ball;
            boolean reached = true;

            while (row < m && col < n) {
                if (grid[row][col] == 1) {
                    if (col == n - 1 || grid[row][col + 1] == -1) {
                        reached = false;
                        break;
                    }
                    col++;
                } else if (grid[row][col] == -1) {
                    if (col == 0 || grid[row][col - 1] == 1) {
                        reached = false;
                        break;
                    }
                    col--;
                }
                row++;
            }

            if (reached)
                result[ball] = col;
            else
                result[ball] = -1;
        }

        return result;
    }
}
