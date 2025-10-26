class Solution {
    public int[][] generateMatrix(int n) {
        if (n == 0)
            return new int[0][0];
        
        int[][] matrix = new int[n][n];
        int top = 0;
        int down = n - 1;
        int left = 0;
        int right = n - 1;
        
        int id = 0;
        int counter = 1;
        
        while (top <= down && left <= right) {
            // left to right
            if (id == 0) {
                for (int i = left; i <= right; i++) {
                    matrix[top][i] = counter++;
                }
                top++;
            }
            
            // top to down
            else if (id == 1) {
                for (int i = top; i <= down; i++) {
                    matrix[i][right] = counter++;
                }
                right--;
            }
            
            // right to left
            else if (id == 2) {
                for (int i = right; i >= left; i--) {
                    matrix[down][i] = counter++;
                }
                down--;
            }
            
            // down to top
            else if (id == 3) {
                for (int i = down; i >= top; i--) {
                    matrix[i][left] = counter++;
                }
                left++;
            }
            
            id = (id + 1) % 4;
        }
        
        return matrix;
    }
}
