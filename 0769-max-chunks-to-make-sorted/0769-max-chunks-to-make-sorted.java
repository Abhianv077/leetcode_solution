class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int cumSum = 0;
        int normalSum = 0;

        int chunksCount = 0;
        for (int i = 0; i < n; i++) {
            cumSum += arr[i];
            normalSum += i;

            if (cumSum == normalSum) {
                chunksCount++;
            }
        }

        return chunksCount;
    }
}