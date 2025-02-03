class Solution 
{
    public int minimumTotal(List<List<Integer>> triangle) 
    {
        int n = triangle.size();
        int dp[] = new int[n];
        for(int j=0;j<n;j++)
            dp[j] = triangle.get(n-1).get(j);
        
        for(int i=n-2;i>=0;i--)
        {
            int temp[] = new int[n];
            for(int j=i;j>=0;j--)
            {
                int d = triangle.get(i).get(j)+dp[j];
                int dg = triangle.get(i).get(j)+dp[j+1];
                temp[j] = Math.min(d,dg);
            }
            dp=temp;
        }
        return dp[0];
    }
}