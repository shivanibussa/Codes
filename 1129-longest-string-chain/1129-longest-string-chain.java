class Solution 
{
    public int longestStrChain(String[] words) 
    {
        int n = words.length,maxi=0;
        int dp[] = new int[n];
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        for(int i=0;i<n;i++)
            dp[i]=1;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(compareWords(words[i],words[j]) && dp[j]+1>dp[i])
                {
                    dp[i] = 1+dp[j];
                }
            }
            maxi = Math.max(maxi,dp[i]);
        }

        return maxi;
    }
    public boolean compareWords(String s1, String s2)
    {
        if(s1.length()-s2.length()!=1)
            return false;
        int f=0,s=0;
        while(f<s1.length())
        {
            if(s<s2.length() && s1.charAt(f)==s2.charAt(s))
            {
                f++;
                s++;
            }
            else
            {
                f++;
            }
        }
        if(f==s1.length() && s==s2.length())
            return true;
        return false;
    }
}