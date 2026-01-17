class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;

        int[] vec = new int[n];
       
        vec[0] = values[0] + 0;

        for (int i = 1; i < n; i++) {
            vec[i] = Math.max(values[i] + i, vec[i - 1]);
        }

        int result = 0;

        for (int j = 1; j < n; j++) {
            int x = values[j] - j;
            int y = vec[j - 1];
            result = Math.max(result, x + y);
        }

        return result;
    }
}
