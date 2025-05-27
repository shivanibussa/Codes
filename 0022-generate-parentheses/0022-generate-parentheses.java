class Solution 
{
    public List<String> generateParenthesis(int n) 
    {
        List<String> arr = new ArrayList<>();
         f("",0,0,n,arr);
         return arr;
    }
    public void f(String s,int open,int close,int n,List<String> arr)
    {
        if(open == n && close==n){
            arr.add(s);
        }
        if(open<n)
            f(s+"(",open+1,close,n,arr);
        if(close<open)
            f(s+")",open,close+1,n,arr);
    }
}