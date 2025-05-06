class Solution 
{
    public int minimumTotal(List<List<Integer>> triangle) 
    {
        int n = triangle.size();
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
                int diagonal = triangle.get(i).get(j)+dp[j+1];

                temp[j] = Math.min(down,diagonal);
            }
            dp = temp;
        }
        return dp[0];
    }
    public int f(int i,int j,List<List<Integer>> triangle,int n)
    {
        if(i==n-1)
            return triangle.get(i).get(j);

        int down = triangle.get(i).get(j)+f(i+1,j,triangle,n);
        int diagonal = triangle.get(i).get(j)+f(i+1,j+1,triangle,n);
        return Math.min(down,diagonal);
    }
}