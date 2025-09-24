import java.util.*;

class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        // Map to store diagonals based on key (i - j)
        Map<Integer, List<Integer>> mp = new HashMap<>();

        // Store diagonal elements
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mp.computeIfAbsent(i - j, k -> new ArrayList<>()).add(mat[i][j]);
            }
        }

        // Sort diagonals
        for (List<Integer> list : mp.values()) {
            Collections.sort(list, Collections.reverseOrder()); // reverse for easier pop_back
        }

        // Put back in sorted order
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                List<Integer> list = mp.get(i - j);
                mat[i][j] = list.remove(list.size() - 1); // take last element
            }
        }

        return mat;
    }
}
