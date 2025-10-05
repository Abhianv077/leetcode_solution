
class Solution {
    public int countOverlaps(int[][] A, int[][] B, int rowOff, int colOff) {
        int n = A.length;
        int count = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                int newRow = row + rowOff;
                int newCol = col + colOff;

                if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= n) {
                    continue;
                }

                count += A[row][col] * B[newRow][newCol];
            }
        }

        return count;
    }

    public int largestOverlap(int[][] A, int[][] B) {
        int n = A.length;
        int maxOverlap = 0;

        for (int rowOff = -n + 1; rowOff < n; rowOff++) {
            for (int colOff = -n + 1; colOff < n; colOff++) {
                maxOverlap = Math.max(maxOverlap, countOverlaps(A, B, rowOff, colOff));
            }
        }

        return maxOverlap;
    }
}
