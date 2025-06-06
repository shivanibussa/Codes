class Solution 
{
    static Boolean isSubsetSum(int arr[], int sum) 
    {
        int n = arr.length;
        boolean dp[][] = new boolean[n][sum+1];
        
        for(int i=0;i<n;i++)
        {
            dp[i][0] = true;
        }
        if(arr[0]<=sum)
            dp[0][arr[0]] = true;
        for(int i=1;i<n;i++)
        {
            for(int j=1;j<=sum;j++)
            {
                boolean take = false;
                boolean not_take = dp[i-1][j];
                if(j>=arr[i])
                    take = dp[i-1][j-arr[i]];
                    
                dp[i][j] = take||not_take;
            }
        }
        return dp[n-1][sum];
    }
    static Boolean f(int arr[],int target,int ind)
    {
        if(target==0)
            return true;
        if(ind==0)
        {
            return arr[0]==target;
        }
        
        boolean take = false;
        boolean not_take = f(arr,target,ind-1);
        if(arr[ind]<=target)
            take = f(arr,target-arr[ind],ind-1);
        
        return take||not_take;
    }
}