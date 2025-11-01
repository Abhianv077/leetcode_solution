class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int n = intervals.length;
        
        int count = 0;
        int i = 0, j = 1;
        
        while (j < n) {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];
            int nextStart = intervals[j][0];
            int nextEnd = intervals[j][1];
            
            if (currEnd <= nextStart) {
                // SAFE
                i = j;
                j++;
            } else if (currEnd <= nextEnd) {
                /*
                    GREEDY: Remove next interval as it has high chances to
                    overlap with future intervals
                */
                j++;
                count++;
            } else {
                /*
                    GREEDY: Remove current interval as it has high chances to
                    overlap with future intervals
                */
                i = j;
                j++;
                count++;
            }
        }
        
        return count;
    }
}
