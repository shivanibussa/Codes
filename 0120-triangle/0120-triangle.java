class Solution 
{
    public int minimumTotal(List<List<Integer>> triangle) 
    {
        int m= triangle.size(),n=triangle.get(m-1).size();
        int dp[] = new int[n];
        for(int j=0;j<n;j++)
        {
            dp[j] = triangle.get(n-1).get(j);
        }
        for(int i=n-2;i>=0;i--)
        {
            int temp[] = new int[n];
            for(int j=i;j>=0;j--)
            {
                int down = triangle.get(i).get(j)+dp[j];
                int diag = triangle.get(i).get(j)+dp[j+1];
                temp[j] = Math.min(down,diag);
            }
            dp=temp;
        }
        return dp[0];
    }
}