class Solution 
{
    public static String infixToPostfix(String s) 
    {
        HashMap<Character,Integer> hm = new HashMap<>();
        Stack<Character> st = new Stack<>();
        hm.put('+',1);
        hm.put('-',1);
        hm.put('*',2);
        hm.put('/',2);
        hm.put('^',3);
        hm.put('(',-1);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch))
            {
                sb.append(ch);
            }
            else
            {
                if(ch=='(')
                    st.push(ch);
                    
                else if(ch==')')
                {
                    while(!st.isEmpty() && st.peek()!='(')
                    {
                        sb.append(st.pop());
                    }
                    st.pop();
                }
                else
                {
                    while(!st.isEmpty() && hm.get(ch)<=hm.get(st.peek()))
                    {
                        sb.append(st.pop());
                    }
                    st.push(ch);
                }
            }
        }
        while(!st.isEmpty())
            sb.append(st.pop());
        return sb.toString();
    }
    
}