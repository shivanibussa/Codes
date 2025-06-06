class Solution 
{
    public int rob(int[] nums) 
    {
        int n=nums.length;
        int dp[] = new int[n];
        int prev=nums[0];
        int prev2=0;
        for(int i=1;i<n;i++)
        {
            int take = nums[i];
            int not_take = 0+prev;
            if(i-2>=0)
                take+=prev2;

            int curr = Math.max(take,not_take);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
    public int f(int i,int nums[])
    {
        if(i==0)
            return nums[i];

        int take = nums[i];
        int not_take = 0+f(i-1,nums);
        if(i-2>=0)
            take+=f(i-2,nums);
        
        return Math.max(take,not_take);
    }
}