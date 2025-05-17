class Solution 
{
    public int rob(int[] nums) 
    {
        int n = nums.length;
        int prev = nums[0],prev2=0;
        for(int i=1;i<n;i++)
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