class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        
        int n = times.length;
        // Priority Queue for occupied chairs, storing {departTime, chairNo}
        PriorityQueue<int[]> occupied = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        // Min heap for free chairs
        PriorityQueue<Integer> free = new PriorityQueue<>();
        
        int targetFriendArrival = times[targetFriend][0];

        // Sort based on arrival time
        Arrays.sort(times, (a, b) -> a[0] - b[0]);
        
        int chairNo = 0;
        
        for (int i = 0; i < n; i++) {
            int arrival = times[i][0];
            int depart = times[i][1];
            
            // Free chairs accordingly
            while (!occupied.isEmpty() && occupied.peek()[0] <= arrival) {
                free.offer(occupied.poll()[1]); // this chair is now free
            }
            
            if (free.isEmpty()) {
                occupied.offer(new int[]{depart, chairNo});
                
                if (arrival == targetFriendArrival)
                    return chairNo;
                
                chairNo++;
            } else {
                int leastChairAvailable = free.poll();
                if (arrival == targetFriendArrival) {
                    return leastChairAvailable;
                }
                occupied.offer(new int[]{depart, leastChairAvailable});
            }
        }
        
        return -1;
    }
}
