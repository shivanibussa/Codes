class Solution 
{
    public boolean canJump(int[] nums) 
    {
        int max = 0, n = nums.length;
        // if(n==1)
        //     return nums[0]==0?false:true;
        for(int i=0;i<n;i++)
        {
            if(i>max)
                return false;
            int jump = i+nums[i];
            max = Math.max(max, jump);
        }
        return max>=n-1 ? true:false;
    }
}