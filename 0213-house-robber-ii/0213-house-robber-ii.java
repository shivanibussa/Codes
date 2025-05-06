class Solution 
{
    public int rob(int[] nums) 
    {
        int n = nums.length;
        if(n==1)
            return nums[0];
        return Math.max(rob(nums,0,n-2),rob(nums,1,n-1));
    }
    public int rob(int[] nums,int s,int e) 
    {
        int prev = 0;
        int prev2 = 0;
        for(int i=s;i<=e;i++)
        {
            int not_take = 0+prev;
            int take = nums[i];
            if(i>=2)
                take += prev2;
            int curr = Math.max(take,not_take);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}