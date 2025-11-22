class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;

        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];

        // Build prefix sum
        for (int i = 1; i < n; i++) {
            prefixSum[i] = nums[i] + prefixSum[i - 1];
        }

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {

            int leftSum = prefixSum[i] - nums[i];
            int rightSum = prefixSum[n - 1] - prefixSum[i];

            int leftCount = i;
            int rightCount = n - i - 1;

            int leftTotal = (leftCount * nums[i]) - leftSum;
            int rightTotal = rightSum - (nums[i] * rightCount);

            result[i] = leftTotal + rightTotal;
        }

        return result;
    }
}
