class Solution 
{
    public List<String> wordBreak(String s, List<String> wordDict) 
    {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        f(s,wordDict,ans,sb,0);
        return ans;
    }
    public void f(String s,List<String> dict,List<String> ans,StringBuilder sb,int ind)
    {
        int n = s.length();
        if(ind==n)
        {
            ans.add(sb.toString().trim());
            return;
        }
        for(int i=ind;i<n;i++)
        {
            if(dict.contains(s.substring(ind,i+1)))
            {
                int len = sb.length();
                sb.append(" ");
                sb.append(s.substring(ind,i+1));
                f(s,dict,ans,sb,i+1);
                sb.setLength(len);
            }
        }
    }
}