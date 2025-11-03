class Solution {
    int m, n;
    int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    
    public int[][] updateMatrix(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        
        Queue<int[]> que = new LinkedList<>();
        int[][] dist = new int[m][n];
        
        // Initialize distance matrix with -1
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], -1);
        }
        
        // Add all 0s to the queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    dist[i][j] = 0;
                    que.offer(new int[]{i, j});
                }
            }
        }
        
        // BFS
        while (!que.isEmpty()) {
            int[] p = que.poll();
            
            for (int[] dir : directions) {
                int i = p[0] + dir[0];
                int j = p[1] + dir[1];
                
                if (isSafe(i, j)) {
                    if (dist[i][j] == -1) {
                        dist[i][j] = dist[p[0]][p[1]] + 1;
                        que.offer(new int[]{i, j});
                    }
                }
            }
        }
        
        return dist;
    }
    
    private boolean isSafe(int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}
