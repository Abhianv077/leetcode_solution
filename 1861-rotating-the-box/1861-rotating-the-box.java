class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;

        char[][] res = new char[n][m];

        // Step 1: Rotate (transpose + reverse rows)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[j][m - 1 - i] = box[i][j];
            }
        }

        // Step 2: Apply gravity column-wise
        for (int col = 0; col < m; col++) {
            int writeRow = n - 1;

            for (int row = n - 1; row >= 0; row--) {
                if (res[row][col] == '*') {
                    writeRow = row - 1;
                } else if (res[row][col] == '#') {
                    res[row][col] = '.';
                    res[writeRow][col] = '#';
                    writeRow--;
                }
            }
        }

        return res;
    }
}
