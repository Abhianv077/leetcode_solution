class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> remainderCount = new HashMap<>();
        remainderCount.put(0, 1); // Base case: prefix sum divisible by k

        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {
            prefixSum += num;

            // Handle negative numbers correctly
            int remainder = ((prefixSum % k) + k) % k;

            // If this remainder has been seen before, add its frequency
            count += remainderCount.getOrDefault(remainder, 0);

            // Store the frequency of this remainder
            remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0) + 1);
        }

        return count;
    }
}
