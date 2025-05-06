class Solution 
{
    public int rob(int[] nums) 
    {
        int n = nums.length;
        int prev = nums[0];
        int prev2=0;
        for(int i=1;i<n;i++)
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
    public int f(int nums[],int n)
    {
        if(n==0)
            return nums[0];
        if(n<0)
            return 0;
        int not_take = 0+f(nums,n-1);
        int take = nums[n]+f(nums,n-2);

        return Math.max(take,not_take);
    }
}