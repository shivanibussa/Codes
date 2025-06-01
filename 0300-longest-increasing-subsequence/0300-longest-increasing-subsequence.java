class Solution 
{
    public int lengthOfLIS(int[] nums) 
    {
        int n = nums.length,res=1;
        int cnt[] = new int[n];
        for(int i=0;i<n;i++)
            cnt[i]=1;

        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[j]<nums[i])
                    cnt[i]=Math.max(cnt[i],1+cnt[j]);
                
            }
            res = Math.max(res,cnt[i]);
            
        }
        return res;
    }
}