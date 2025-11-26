class Solution {

    // Directions array (same as C++)
    int[][] directions = {
        {-1, -1}, {-1, 0}, {-1, 1},
        {0, -1},  {0, 0},  {0, 1},
        {1, -1},  {1, 0},  {1, 1}
    };

    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;

        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int sum = 0;
                int count = 0;

                // Check 9 directions
                for (int[] d : directions) {
                    int i_ = i + d[0];
                    int j_ = j + d[1];

                    if (i_ >= 0 && i_ < m && j_ >= 0 && j_ < n) {
                        sum += img[i_][j_];
                        count++;
                    }
                }

                result[i][j] = sum / count;
            }
        }

        return result;
    }
}
