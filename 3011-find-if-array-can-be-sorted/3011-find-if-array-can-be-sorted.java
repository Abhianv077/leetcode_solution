class Solution {
    public boolean canSortArray(int[] nums) {
        
        int numOfSetBits = Integer.bitCount(nums[0]);
        int maxOfSegment = nums[0];
        int minOfSegment = nums[0];
        int maxOfPrevSegment = Integer.MIN_VALUE;

        for (int i = 1; i < nums.length; i++) {
            if (Integer.bitCount(nums[i]) == numOfSetBits) { 
                maxOfSegment = Math.max(maxOfSegment, nums[i]);
              
                minOfSegment = Math.min(minOfSegment, nums[i]);
            } else { 
                if (minOfSegment < maxOfPrevSegment) { 
                    return false;
                }

               
                maxOfPrevSegment = maxOfSegment;

               
                maxOfSegment = nums[i];
                minOfSegment = nums[i];
                numOfSetBits = Integer.bitCount(nums[i]);
            }
        }

      
        if (minOfSegment < maxOfPrevSegment) {
            return false;
        }
        return true;
    }
}