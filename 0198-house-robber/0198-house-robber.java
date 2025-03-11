class Solution 
{
    public int rob(int[] nums) 
    {
        int n = nums.length;
        int dp[] = new int[n];
        int prev1 = nums[0];
        int prev2 = 0,curr=0;
        for(int i=1;i<n;i++)
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
}