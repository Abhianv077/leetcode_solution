public class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int n = nums.length;
        int m = pattern.length;

        int count = 0;

        for (int i = 0; i < n - m; i++) {

            int k = 0;
            
            while(k < m) {
                if(pattern[k] == 1 && nums[i+k+1] > nums[i+k]) {
                    k++;
                } else if(pattern[k] == 0 && nums[i+k+1] == nums[i+k]) {
                    k++;
                } else if(pattern[k] == -1 && nums[i+k+1] < nums[i+k]) {
                    k++;
                } else {
                    break;
                } 
            }

            if (k == m) { 
                count++;
            }
        }

        return count;
    }
}