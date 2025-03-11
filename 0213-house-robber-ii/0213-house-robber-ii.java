class Solution 
{
    public int rob(int[] nums,int s, int e) 
    {
        int prev1 = nums[s];
        int prev2 = 0,curr=0;
        for(int i=s+1;i<=e;i++)
        {
            int pick = nums[i];
            if(i>1)
                pick +=prev2;
            int not_pick = prev1;
            curr = Math.max(pick,not_pick);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
    public int rob(int[] nums) 
    {
        int n = nums.length;
        if(n==1)
            return nums[0];
        return Math.max(rob(nums,0,n-2),rob(nums,1,n-1));
    }
}