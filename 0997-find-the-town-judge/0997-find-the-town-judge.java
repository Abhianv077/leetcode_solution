class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] count = new int[n + 1];
        
        for (int[] t : trust) {
            count[t[0]]--;  // person who trusts someone
            count[t[1]]++;  // person who is trusted
        }
        
        for (int i = 1; i <= n; i++) {
            if (count[i] == n - 1) {
                return i;  // found the judge
            }
        }
        
        return -1;  // no judge found
    }
}

