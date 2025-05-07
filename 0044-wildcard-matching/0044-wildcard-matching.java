class Solution 
{
    public boolean isMatch(String s, String p) 
    {
        int m = s.length(),n=p.length();
        int dp[][] = new int[m+1][n+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return f(m-1,n-1,s,p,dp);
    }
    public boolean f(int i,int j,String s,String p,int dp[][])
    {
        if(j<0 && i<0)
            return true;
        if(i>=0 && j<0)
            return false;
        if(i<0 && j>=0)
        {
            for(int ind=0;ind<=j;ind++)
            {
                if(p.charAt(ind)!='*')
                    return false;
            }
            return true;
        }
        if(dp[i][j]!=-1)
            return dp[i][j]==1?true:false;

        if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?')
            dp[i][j] = f(i-1,j-1,s,p,dp)?1:0; 
        else if(p.charAt(j)=='*')
            dp[i][j] = f(i-1,j,s,p,dp)||f(i,j-1,s,p,dp)?1:0;
        else
            dp[i][j] = 0;

        return dp[i][j]==1;
    }
}