class Solution 
{
    public int rob(int[] nums) 
    {
        int prev = nums[0];
        int prev2 = 0;
        for(int i=1;i<nums.length;i++)
        {
            int take = nums[i];
            if(i>1)
                take+=prev2;
            int non_take = prev;
            int curri = Math.max(take,non_take);
            prev2 = prev;
            prev = curri;
        }
        return prev;
    }
}