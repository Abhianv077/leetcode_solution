public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);

            if (nums[num - 1] < 0) {
                result.add(num);
            } else {
                nums[num - 1] *= -1;
            }
        }

        return result;
    }
}