class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {

        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{0, 0});

        List<Integer> ans = new ArrayList<>();

        while (!que.isEmpty()) {
            int[] p = que.poll();
            int row = p[0];
            int col = p[1];

            ans.add(nums.get(row).get(col));

            if (col == 0 && row + 1 < nums.size()) {
                que.offer(new int[]{row + 1, 0});
            }

            if (col + 1 < nums.get(row).size()) {
                que.offer(new int[]{row, col + 1});
            }
        }

        // Convert List<Integer> → int[]
        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }
}
