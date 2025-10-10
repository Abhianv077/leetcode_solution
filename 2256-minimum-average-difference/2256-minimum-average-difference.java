class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        
        // Total Sum
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        
        long leftSum = 0;
        long rightSum = 0;
        
        int result = Integer.MAX_VALUE;
        int index = -1;
        
        for (int i = 0; i < n; i++) {
            leftSum += nums[i];
            rightSum = sum - leftSum;
            
            int n1 = i + 1;
            int n2 = n - n1;
            
            long leftAvg = leftSum / n1;
            long rightAvg = (i == n - 1) ? 0 : rightSum / n2;
            
            int diff = (int)Math.abs(leftAvg - rightAvg);
            
            if (result > diff) {
                result = diff;
                index = i;
            }
        }
        
        return index;
    }
}
