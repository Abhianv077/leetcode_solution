class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                if (nums[i]+nums[j]==target){
                    int ans[]=new int[2];
                    ans[0]=i;
                    ans[1]=j;
                    return ans;
                }
            }
        }
        int answ[] = new int[2];
        answ[0]=answ[1]=0;
        return answ;
    }
}