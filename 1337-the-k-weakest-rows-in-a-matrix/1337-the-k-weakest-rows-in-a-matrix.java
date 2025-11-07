class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        List<int[]> countOnes = new ArrayList<>();
        int index = 0;

        for (int[] row : mat) {
            int soldiers = binarySearch(row);
            countOnes.add(new int[]{index++, soldiers});
        }

        // Sort by number of soldiers, and if equal, by index
        countOnes.sort((a, b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = countOnes.get(i)[0];
        }

        return result;
    }

    // Binary search to count number of soldiers (1's)
    private int binarySearch(int[] row) {
        int left = 0, right = row.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (row[mid] == 1) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result + 1; // number of soldiers
    }
}
