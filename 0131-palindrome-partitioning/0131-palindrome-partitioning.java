class Solution 
{
    public List<List<String>> partition(String s) 
    {
        List<List<String>> res = new ArrayList<>();
        List<String> arr = new ArrayList<>();
        f(res,arr,s,0);
        return res;
    }
    public void f(List<List<String>> res,List<String> arr,String s,int ind)
    {
        if(ind==s.length())
        {
            res.add(new ArrayList<>(arr));
            return;
        }

        for(int i=ind;i<s.length();i++)
        {
            if(isPalindrome(s,ind,i))
            {
                arr.add(s.substring(ind,i+1));
                f(res,arr,s,i+1);
                arr.remove(arr.size()-1);
            }
        }
    }

    public static boolean isPalindrome(String s,int i,int j)
    {
        while(i<=j)
        {
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}