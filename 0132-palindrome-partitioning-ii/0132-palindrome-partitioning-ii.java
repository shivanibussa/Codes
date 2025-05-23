class Solution 
{
    public int minCut(String s) 
    {
        int dp[] = new int[s.length()+2];
        for(int i=s.length()-1;i>=0;i--)
        {
            int minC = Integer.MAX_VALUE;
            for(int j=i;j<s.length();j++)
            {
                if(CheckP(i,j,s)==true)
                {
                    int cuts =  1+dp[j+1];
                    minC = Math.min(cuts,minC);
                }
            }
            dp[i] = minC;
        }
        return dp[0]-1;
    }
    public int f(String s,int i)
    {
        if(i==s.length())
            return 0;
        int minC = Integer.MAX_VALUE;
        for(int j=i;j<s.length();j++)
        {
            if(CheckP(i,j,s)==true)
            {
                int cuts =  1+f(s,j+1);
                minC = Math.min(cuts,minC);
            }
        }
        return minC;
    }
    public boolean CheckP(int st,int e,String s)
    {
        while(st<e)
        {
            if(s.charAt(st)==s.charAt(e))
            {
                st++;e--;
            }
            else
                return false;
        }
        return true;
    }
}