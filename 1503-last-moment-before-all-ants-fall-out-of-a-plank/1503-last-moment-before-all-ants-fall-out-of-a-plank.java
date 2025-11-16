class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int result = 0;

        // For ants moving left
        for (int x : left) {
            result = Math.max(result, x);
        }

        // For ants moving right
        for (int x : right) {
            result = Math.max(result, n - x);
        }

        return result;
    }
}
