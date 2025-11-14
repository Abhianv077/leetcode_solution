class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int m = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[m++] = nums[i];
            }
        }

        int ans = Integer.MAX_VALUE;

        int left = 0;
        for (int right = 0; right < m; right++) {
     
            while (nums[right] - nums[left] >= n) {
                left++;
            }

         
            int uniqueInside = right - left + 1;
            ans = Math.min(ans, n - uniqueInside);
        }

        return ans;
    }
}
