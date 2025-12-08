class Solution {
    int m;
    int n;
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    int bfs(int[][] grid, int i, int j) {
        int perim = 0;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        grid[i][j] = -1;
        
        while (!queue.isEmpty()) {
            int[] it = queue.poll();
            
            for (int[] dir : directions) {
                int i_ = it[0] + dir[0];
                int j_ = it[1] + dir[1];
                
                if (i_ < 0 || i_ >= m || j_ < 0 || j_ >= n || grid[i_][j_] == 0)
                    perim++;
                else if (grid[i_][j_] == -1)
                    continue;
                else {
                    queue.offer(new int[]{i_, j_});
                    grid[i_][j_] = -1;
                }
            }
        }
        
        return perim;
    }
    
    int islandPerimeter(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return bfs(grid, i, j);
                }
            }
        }
        
        return -1;
    }
}
