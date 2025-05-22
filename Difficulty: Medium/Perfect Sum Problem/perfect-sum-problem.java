class Solution 
{
    
    public int perfectSum(int[] arr, int sum) 
    {
        int n = arr.length;
        int dp[][] = new int[n][sum+1];
        // for(int i=0;i<n;i++)
        //     dp[i][0] = 1;
        
        if(arr[0]<=sum)
            dp[0][arr[0]] = 1;
        
        dp[0][0] = (arr[0] == 0) ? 2 : 1;  
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<=sum;j++)
            {
                int not_take = dp[i-1][j];
                int take= 0;
                if(j>=arr[i])
                    take = dp[i-1][j-arr[i]];
                    
                dp[i][j] = take+not_take;
            }
        }
        return dp[n-1][sum];
    }
    
    public int f(int nums[],int target,int ind)
    {
        if (ind < 0) {
            return target == 0 ? 1 : 0;
        }
        int not_take = f(nums,target,ind-1),take=0;
        
        if(nums[ind]<=target)
            take = f(nums,target-nums[ind],ind-1);
            
            
        return not_take+take;
    }
}