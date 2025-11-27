class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int n = points.length;

        // Sort by x-coordinate
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

        int maxVal = 0;

        for (int i = 1; i < n; i++) {
            maxVal = Math.max(maxVal, points[i][0] - points[i - 1][0]);
        }

        return maxVal;
    }
}
