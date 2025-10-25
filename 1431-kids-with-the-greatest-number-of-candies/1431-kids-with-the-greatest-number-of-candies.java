class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n = candies.length;
        int maxC = 0;
        
        // Find the maximum number of candies
        for (int c : candies) {
            maxC = Math.max(maxC, c);
        }
        
        List<Boolean> result = new ArrayList<>();
        
        // Check for each child
        for (int i = 0; i < n; i++) {
            if (candies[i] + extraCandies >= maxC) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        
        return result;
    }
}
