class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int n = garbage.length;

        int G = 0;  // last index of G
        int M = 0;  // last index of M
        int P = 0;  // last index of P

        int total = 0; // total time to pick all garbage

        // Count total garbage + track last house for M, P, G
        for (int i = 0; i < n; i++) {
            String s = garbage[i];
            for (int j = 0; j < s.length(); j++) {

                char c = s.charAt(j);
                if (c == 'M') {
                    M = i;
                } else if (c == 'P') {
                    P = i;
                } else { // G
                    G = i;
                }
                total++;
            }
        }

        // Prefix sum for travel time
        for (int i = 1; i < travel.length; i++) {
            travel[i] += travel[i - 1];
        }

        // Add travel time for trucks
        if (M > 0) total += travel[M - 1];
        if (P > 0) total += travel[P - 1];
        if (G > 0) total += travel[G - 1];

        return total;
    }
}
