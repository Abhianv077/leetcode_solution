
import java.util.*;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);  // handle case where subarray starts from index 0
        
        int sum = 0;
        
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            
            int remainder = sum % k;
            
            // Handle negative remainder (if nums contain negatives)
            if (remainder < 0) {
                remainder += k;
            }
            
            if (map.containsKey(remainder)) {
                if (i - map.get(remainder) >= 2) {
                    return true;
                }
            } else {
                map.put(remainder, i);
            }
        }
        return false;
    }
}

