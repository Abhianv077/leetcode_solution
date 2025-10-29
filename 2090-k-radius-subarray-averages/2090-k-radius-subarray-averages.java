class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        
        if (k == 0)
            return nums;
        
        int[] result = new int[n];
        Arrays.fill(result, -1);
        
        if (n < 2 * k + 1)
            return result;
        
        long[] prefixSum = new long[n];
        prefixSum[0] = nums[0];
        
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        
        for (int i = k; i < n - k; i++) {
            int leftIdx = i - k;
            int rightIdx = i + k;
            
            long sum = prefixSum[rightIdx];
            
            if (leftIdx > 0)
                sum -= prefixSum[leftIdx - 1];
            
            int avg = (int)(sum / (2 * k + 1));
            result[i] = avg;
        }
        
        return result;
    }
}
