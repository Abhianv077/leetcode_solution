class Solution {

    // Binary search function
    public int binarySearch(int[] nums, int n, int target) {
        int l = 0, r = n - 1;
        int mid;
        int resultIdx = -1;

        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] <= target) {
                resultIdx = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return resultIdx + 1;
    }

    public int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length;

        Arrays.sort(nums);
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
        }

        int m = queries.length;
        int[] result = new int[m];

        for (int i = 0; i < m; i++) {
            result[i] = binarySearch(nums, n, queries[i]);
        }

        return result;
    }

    // Optional main method for testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {4, 5, 2, 1};
        int[] queries = {3, 10, 21};
        int[] ans = sol.answerQueries(nums, queries);

        System.out.println(Arrays.toString(ans)); // Example output: [2, 3, 4]
    }
}
