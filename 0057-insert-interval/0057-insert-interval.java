import java.util.*;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        while (i < n) {
            if (intervals[i][1] < newInterval[0]) {
                // Current interval ends before newInterval starts
                result.add(intervals[i]);
                i++;
            } else if (intervals[i][0] > newInterval[1]) {
                // Current interval starts after newInterval ends
                result.add(newInterval);
                // Add remaining intervals
                while (i < n) {
                    result.add(intervals[i]);
                    i++;
                }
                return result.toArray(new int[result.size()][]);
            } else {
                // Overlapping intervals -> merge
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
                i++;
            }
        }

        // Add the merged interval at the end
        result.add(newInterval);
        return result.toArray(new int[result.size()][]);
    }
}
