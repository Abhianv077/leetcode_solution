class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;

        int num1 = Integer.MAX_VALUE;
        int num2 = Integer.MAX_VALUE;

        for (int num3 : nums) {
            if (num3 <= num1) {
                num1 = num3; // smallest so far
            } else if (num3 <= num2) {
                num2 = num3; // second smallest so far
            } else {
                // found num1 < num2 < num3
                return true;
            }
        }

        return false;
    }
}
