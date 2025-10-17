class Solution {
    int n;
    
    private int[] getCoord(int s) {
        int row = n - 1 - (s - 1) / n;
        int col = (s - 1) % n;
        
        if ((n % 2 == 1 && row % 2 == 1) || (n % 2 == 0 && row % 2 == 0)) {
            col = n - 1 - col;
        }
        
        return new int[]{row, col};
    }
    
    public int snakesAndLadders(int[][] board) {
        n = board.length;
        int steps = 0;
        Queue<Integer> que = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        
        visited[n - 1][0] = true;
        que.offer(1);
        
        while (!que.isEmpty()) {
            int size = que.size();
            
            while (size-- > 0) {
                int x = que.poll();
                
                if (x == n * n)
                    return steps;
                
                for (int k = 1; k <= 6; k++) {
                    if (x + k > n * n)
                        break;
                    
                    int[] coord = getCoord(x + k);
                    int r = coord[0];
                    int c = coord[1];
                    
                    if (visited[r][c])
                        continue;
                    
                    visited[r][c] = true;
                    
                    if (board[r][c] == -1)
                        que.offer(x + k);
                    else
                        que.offer(board[r][c]);
                }
            }
            steps++;
        }
        
        return -1;
    }
}
