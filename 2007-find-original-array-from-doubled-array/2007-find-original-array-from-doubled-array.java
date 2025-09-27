import java.util.*;

class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if (n % 2 != 0) return new int[]{}; // must be even length

        Arrays.sort(changed);
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : changed) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        for (int num : changed) {
            if (freq.get(num) == 0) continue; // already used
            
            if (freq.getOrDefault(num * 2, 0) == 0) {
                return new int[]{}; // cannot find double
            }

            // use one occurrence of num and 2*num
            freq.put(num, freq.get(num) - 1);
            freq.put(num * 2, freq.get(num * 2) - 1);

            result.add(num);
        }

        // convert to int[]
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }
}
