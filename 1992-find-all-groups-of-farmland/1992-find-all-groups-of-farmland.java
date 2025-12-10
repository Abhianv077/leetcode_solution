class Solution {
    int m;
    int n;
    List<List<Integer>> result;
        
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    void bfs(int[][] land, int i, int j, int[] r2, int[] c2) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        
        while (!queue.isEmpty()) {
            
            int[] p = queue.poll();
            
            r2[0] = Math.max(r2[0], p[0]);
            c2[0] = Math.max(c2[0], p[1]);
            
            for (int[] dir : directions) {
                int i_ = p[0] + dir[0];
                int j_ = p[1] + dir[1];
                
                if (i_ >= 0 && i_ < m && j_ >= 0 && j_ < n && land[i_][j_] == 1) {
                    land[i_][j_] = 0; // Mark as visited
                    queue.offer(new int[]{i_, j_});
                }
            }
        }
    }
    
    public int[][] findFarmland(int[][] land) {
        m = land.length;
        n = land[0].length;
        result = new ArrayList<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                if (land[i][j] == 1) {
                    int r1 = i;
                    int c1 = j;
                    int[] r2 = {-1};
                    int[] c2 = {-1};
                    
                    bfs(land, i, j, r2, c2);
                    result.add(List.of(r1, c1, r2[0], c2[0]));
                }
                
            }
        }
        
        int[][] resArray = new int[result.size()][4];
        for (int i = 0; i < result.size(); i++) {
            List<Integer> resList = result.get(i);
            resArray[i] = resList.stream().mapToInt(Integer::intValue).toArray();
        }
        
        return resArray;
    }
}
