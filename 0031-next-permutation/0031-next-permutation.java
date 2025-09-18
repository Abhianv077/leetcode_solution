import java.util.*;

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int main_index = -1;

        // Step 1: Find the pivot (first decreasing element from the right)
        for (int i = n - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                main_index = i - 1;
                break;
            }
        }

        if (main_index != -1) {
            // Step 2: Find element just larger than nums[main_index]
            int swap_index = -1;
            for (int j = n - 1; j > main_index; j--) {
                if (nums[j] > nums[main_index]) {
                    swap_index = j;
                    break;
                }
            }
            // Step 3: Swap
            swap(nums, main_index, swap_index);
        }

        // Step 4: Reverse the suffix
        reverse(nums, main_index + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    // Test
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 2, 3};
        sol.nextPermutation(nums);
        System.out.println(Arrays.toString(nums)); // [1, 3, 2]
    }
}
