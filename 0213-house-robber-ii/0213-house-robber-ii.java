class Solution 
{
    public int solve (int nums[],int s, int e)
    {
        int prev = 0;
        int prev2 =0;
        for(int i=s;i<=e;i++)
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
    public int rob(int[] nums) 
    {
        int n = nums.length;
        if (n == 1) return nums[0];
        int ans1 = solve(nums,0,n-2);
        int ans2 = solve(nums,1,n-1);

        return Math.max(ans1,ans2);
    }
}