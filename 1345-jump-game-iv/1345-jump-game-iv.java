class Solution {
    public int solveBFS(int[] arr, int n) {
        boolean[] visited = new boolean[n];
        Map<Integer, List<Integer>> map = new HashMap<>();

        // Store all indices for each value
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int curr = queue.poll();

                if (curr == n - 1) {
                    // BFS ensures the minimum number of steps
                    return steps;
                }

                int left = curr - 1;
                int right = curr + 1;

                if (left >= 0 && !visited[left]) {
                    queue.offer(left);
                    visited[left] = true;
                }

                if (right < n && !visited[right]) {
                    queue.offer(right);
                    visited[right] = true;
                }

                if (map.containsKey(arr[curr])) {
                    for (int idx : map.get(arr[curr])) {
                        if (!visited[idx]) {
                            queue.offer(idx);
                            visited[idx] = true;
                        }
                    }
                    // Erase the entry to prevent future redundant checks (avoid TLE)
                    map.remove(arr[curr]);
                }
            }
            steps++;
        }
        return -1;
    }

    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n == 1)
            return 0;
        return solveBFS(arr, n);
    }
}
