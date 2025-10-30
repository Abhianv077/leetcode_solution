class Solution {
    
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length;
        int n = grid[0].length();
        
        Queue<int[]> queue = new LinkedList<>(); // {x, y, steps, keyStatus}
        int keyCount = 0;
        
        // Find the starting position and count keys
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = grid[i].charAt(j);
                if (ch == '@') {
                    queue.offer(new int[]{i, j, 0, 0});
                } else if (ch >= 'a' && ch <= 'f') {
                    keyCount++;
                }
            }
        }
        
        int finalKeyStatus = (1 << keyCount) - 1; // All keys collected bitmask
        
        boolean[][][] visited = new boolean[m][n][finalKeyStatus + 1];
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int i = curr[0], j = curr[1], steps = curr[2], keyStatus = curr[3];
            
            if (keyStatus == finalKeyStatus) {
                return steps; // All keys collected
            }
            
            for (int[] dir : directions) {
                int newI = i + dir[0];
                int newJ = j + dir[1];
                
                if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && grid[newI].charAt(newJ) != '#') {
                    char ch = grid[newI].charAt(newJ);
                    
                    if (ch >= 'A' && ch <= 'F') { // Lock
                        // Can we open it?
                        if (((keyStatus >> (ch - 'A')) & 1) == 1 && !visited[newI][newJ][keyStatus]) {
                            visited[newI][newJ][keyStatus] = true;
                            queue.offer(new int[]{newI, newJ, steps + 1, keyStatus});
                        }
                    } else if (ch >= 'a' && ch <= 'f') { // Key
                        int newKeyStatus = keyStatus | (1 << (ch - 'a'));
                        if (!visited[newI][newJ][newKeyStatus]) {
                            visited[newI][newJ][newKeyStatus] = true;
                            queue.offer(new int[]{newI, newJ, steps + 1, newKeyStatus});
                        }
                    } else { // Normal cell or start
                        if (!visited[newI][newJ][keyStatus]) {
                            visited[newI][newJ][keyStatus] = true;
                            queue.offer(new int[]{newI, newJ, steps + 1, keyStatus});
                        }
                    }
                }
            }
        }
        
        return -1;
    }
}
