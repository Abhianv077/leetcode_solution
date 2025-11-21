class Solution {

    // Function to check if array can form arithmetic sequence
    public boolean check(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;

        int d = arr[1] - arr[0];

        for (int i = 2; i < n; i++) {
            if (arr[i] - arr[i - 1] != d) {
                return false;
            }
        }
        return true;
    }

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int m = l.length;

        List<Boolean> result = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            // Extract subarray nums[l[i] ... r[i]]
            int size = r[i] - l[i] + 1;
            int[] arr = new int[size];

            for (int j = 0; j < size; j++) {
                arr[j] = nums[l[i] + j];
            }

            result.add(check(arr));
        }

        return result;
    }
}
