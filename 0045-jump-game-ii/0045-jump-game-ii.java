class Solution 
{
    public int jump(int[] nums) 
    {
    int farthest=0,jumps=0,l=0,r=0;
    int n=nums.length;
    while(r<n-1)
    {
        for(int i=l;i<=r;i++)
        {
            farthest = Math.max(farthest,nums[i]+i);       
        }   
        l = r+1;
        r=farthest;
        jumps++;

          if (l > r) break;
        
    }        
    return jumps;
    }
}