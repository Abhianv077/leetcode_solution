class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = 0, leftSum = 0;
        
        // calculate total sum
        for (int num : nums) {
            totalSum += num;
        }
        
        // check pivot index
        for (int i = 0; i < nums.length; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            if (leftSum == rightSum) {
                return i; 
            }
            leftSum += nums[i];
        }
        
        return -1;
    }
}
