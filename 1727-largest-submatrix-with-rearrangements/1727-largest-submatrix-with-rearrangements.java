class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int result = 0;

        for (int row = 0; row < m; row++) {

            // Build heights for histogram-like matrix
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == 1 && row > 0) {
                    matrix[row][col] += matrix[row - 1][col];
                }
            }

            // Copy current row values
            int[] currRow = Arrays.copyOf(matrix[row], n);

            // Sort in decreasing order
            Arrays.sort(currRow);
            reverse(currRow);

            // Calculate max area using heights
            for (int col = 0; col < n; col++) {
                int base = col + 1;     // width
                int height = currRow[col];
                result = Math.max(result, base * height);
            }
        }

        return result;
    }

    // Helper function to reverse array
    private void reverse(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}
