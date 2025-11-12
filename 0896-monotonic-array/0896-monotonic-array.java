class Solution {
    public boolean isMonotonic(int[] nums) {
        int n = nums.length;
        
        boolean increasing = false;
        boolean decreasing = false;
        
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                increasing = true;
            }
            if (nums[i] > nums[i + 1]) {
                decreasing = true;
            }
        }
        
        if (increasing && decreasing)
            return false;
        
        return true;
    }

    // For testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = {1, 2, 2, 3};
        int[] nums2 = {6, 5, 4, 4};
        int[] nums3 = {1, 3, 2};

        System.out.println("Is nums1 monotonic? " + sol.isMonotonic(nums1)); // true
        System.out.println("Is nums2 monotonic? " + sol.isMonotonic(nums2)); // true
        System.out.println("Is nums3 monotonic? " + sol.isMonotonic(nums3)); // false
    }
}
