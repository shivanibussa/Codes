
class Solution 
{
    int countPartitions(int[] arr, int d) 
    {
        int sum = 0;
    int n = arr.length;
    for(int no : arr)
        sum += no;
        
    int k = sum - d;
    if(k < 0 || k % 2 != 0)
        return 0;
    sum = k / 2;
    
    int[][] dp = new int[n][sum + 1];
    
    // Initialize first row safely:
    if (arr[0] <= sum)
        dp[0][arr[0]] = 1;
    
    dp[0][0] = (arr[0] == 0) ? 2 : 1;
    
    for(int i = 1; i < n; i++) 
    {
        for(int j = 0; j <= sum; j++) 
        {
            int not_take = dp[i - 1][j];
            int take = 0;
            if(arr[i] <= j)
                take = dp[i - 1][j - arr[i]];
            
            dp[i][j] = not_take + take;
        }
    }
    return dp[n - 1][sum];
}
}
