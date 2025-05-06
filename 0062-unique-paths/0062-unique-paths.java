class Solution 
{
    public int uniquePaths(int m, int n) 
    {
        int dp[] = new int[n];
        for(int i=0;i<m;i++)
        {
            int temp[] = new int[n];
            for(int j=0;j<n;j++)
            {
                if(i==0 && j==0)
                {
                    temp[j] = 1;
                }
                else
                {
                    int up=0,left=0;
                    if(i>0)
                        up = dp[j];
                    if(j>0)
                        left = temp[j-1];

                    temp[j] = up+left;
                }

            }
            dp = temp;
        }
        return dp[n-1];
    }
    public int f(int i,int j)
    {
        if(i==0 && j==0)
            return 1;
        int up=0,left=0;
        if(i>0)
            up = f(i-1,j);
        if(j>0)
            left = f(i,j-1);

        return up+left;
    }
}