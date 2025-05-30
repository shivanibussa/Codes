class Solution
{
    public String longestPalindrome(String s) 
    {
        String res = "";
        for(int i=0;i<s.length();i++)
        {
            String odd = expandAround(s,i,i);
            String even = expandAround(s,i,i+1);

            if(odd.length() > res.length())
                res = odd;

            if(even.length() > res.length())
                res = even;
        }        
        return res;
    }

    public String expandAround(String s,int l,int r)
    {
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r))
        {
            l--;
            r++;
        }
        return s.substring(l+1,r);
    }
}