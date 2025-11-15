class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> row = new ArrayList<>();
            
            // Fill with 1 initially
            for (int k = 0; k <= i; k++) {
                row.add(1);
            }

            // Fill middle values
            for (int j = 1; j < i; j++) {
                row.set(j, result.get(i - 1).get(j) + result.get(i - 1).get(j - 1));
            }

            result.add(row);
            
            if (i == rowIndex) {
                return row;  // Return the rowIndex-th row
            }
        }
        
        return new ArrayList<>();
    }
}
