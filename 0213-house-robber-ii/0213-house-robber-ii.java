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
        int n = nums.length;
        int prev = nums[s],prev2=0;
        for(int i=s+1;i<=e;i++)
        {
            int take=nums[i];
            int not_take = 0+prev;
            if(i-2>=0)
                take +=prev2;

            int curr = Math.max(take,not_take);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
}