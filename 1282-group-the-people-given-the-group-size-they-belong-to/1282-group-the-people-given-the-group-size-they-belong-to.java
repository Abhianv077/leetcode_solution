class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int n = groupSizes.length;
        
        // Use a HashMap to store groups by size
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            int size = groupSizes[i];
            
            map.putIfAbsent(size, new ArrayList<>());
            map.get(size).add(i);
            
            // If a group of the required size is complete, add it to the result
            if (map.get(size).size() == size) {
                result.add(new ArrayList<>(map.get(size)));
                map.get(size).clear(); // reset the list for next group
            }
        }
        
        return result;
    }
}
