class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int n = nums.length;
        int[] freq = new int[n + 1];

        List<List<Integer>> result = new ArrayList<>();

        for (int num : nums) {
            int f = freq[num];

  
            if (f == result.size()) {
                result.add(new ArrayList<>());
            }

        
            result.get(f).add(num);

    
            freq[num]++;
        }

        return result;
    }
}
