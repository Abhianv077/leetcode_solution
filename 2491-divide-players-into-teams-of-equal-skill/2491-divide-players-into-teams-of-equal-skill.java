class Solution {
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        
        // Sort the skill array
        Arrays.sort(skill);
        
        int i = 0;
        int j = n - 1;
        int s = skill[i] + skill[j];
        
        long chem = 0;
        
        // Check each pair from both ends of the sorted array
        while (i < j) {
            int currSkill = skill[i] + skill[j];
            
            // If current pair sum is not equal to expected sum, return -1
            if (currSkill != s) {
                return -1;
            }
            
            // Calculate the chemistry and move to the next pair
            chem += (long) skill[i] * (long) skill[j];
            i++;
            j--;
        }
        
        return chem;
    }
}
