class Solution 
{
    public int[] asteroidCollision(int[] asteroids) 
    {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<asteroids.length;i++)
        {
            if(asteroids[i]>0)
                st.push(asteroids[i]);
            
            else 
            {
                while(!st.isEmpty() && st.peek()>0 && st.peek()<Math.abs(asteroids[i]))
                    st.pop();

                if(st.isEmpty() || st.peek()<0)
                    st.push(asteroids[i]);
                else if(Math.abs(asteroids[i])==st.peek())
                    st.pop();
            }
        }
        if(st.size()==0)
            return new int[]{};
        int ans[] = new int[st.size()];
        int c = st.size()-1;
        while(!st.isEmpty()){
            ans[c] = st.pop();
            c--;
        }
        return ans;
    }
}