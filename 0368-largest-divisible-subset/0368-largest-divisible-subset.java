class Solution 
{
    public List<Integer> largestDivisibleSubset(int[] nums) 
    {
        ArrayList<Integer> res = new ArrayList<>();
        int n = nums.length;
        int dp[] = new int[n];
        int hash[] = new int[n];
        int lastIndex=0,maxi=1;
        Arrays.sort(nums);
        for(int i=0;i<n;i++)
        {
            dp[i]=1;hash[i] = i;
            for(int j=0;j<i;j++)
            {
                if(nums[i]%nums[j]==0 && 1+dp[j]>dp[i])
                {
                    dp[i] = 1+dp[j];
                    hash[i] = j;
                }
            }
            if(maxi<dp[i])
            {
                maxi = dp[i];
                lastIndex = i;
            }
        }
        res.add(nums[lastIndex]);
        while(lastIndex!=hash[lastIndex])
        {
            lastIndex = hash[lastIndex];
            res.add(nums[lastIndex]);
        }
        return res;
    }
}