class Solution {
    public int maxTwoEvents(int[][] events) {
        int n = events.length;
        int result = 0;

        for (int i = 0; i < n; i++) {
           
            result = Math.max(result, events[i][2]);

            int val = events[i][2];
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

               
                if (events[j][0] <= events[i][1] && events[j][1] >= events[i][0]) {
                    continue;
                }

                result = Math.max(result, val + events[j][2]);
            }
        }

        return result;
    }
}