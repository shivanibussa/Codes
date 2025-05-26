class Solution 
{
    public String removeKdigits(String num, int k) 
    {
        Stack<Character> st = new Stack<>();
        int len = num.length();
        if(len==k)
            return "0";
        for(int i=0;i<len;i++)
        {
            char ele = num.charAt(i);
            while(!st.isEmpty() && st.peek()>ele && k>0)
            {
                st.pop();
                k--;
            }
            st.push(ele);
        }
        while(k>0)
        {
            st.pop();
            k--;
        }
        StringBuilder  sb = new StringBuilder();
        while(!st.isEmpty())
        {
            sb.append(st.pop());
        }
        sb.reverse();
        String str = sb.toString();
        str = str.replaceFirst("^0+","");
        if(str.length()==0)
            str = "0";
        return str;
    }
}