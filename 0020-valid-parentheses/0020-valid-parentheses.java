class Solution 
{
    public boolean isValid(String s) 
    {
        Stack<Character>st = new Stack<>();
        HashMap<Character,Character> hm = new HashMap<>();
        hm.put(']','[');
        hm.put('}','{');
        hm.put(')','(');
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(ch=='(' || ch=='{' || ch=='[')
            {
                st.push(ch);
            }
            else
            {
                if(!st.isEmpty() && st.peek()==hm.get(ch))
                    st.pop();
                else
                    return false;
            }
            
        }
        return st.isEmpty()==true?true:false;
    }
}