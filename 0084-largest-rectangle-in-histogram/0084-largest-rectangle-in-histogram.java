class Solution 
{
    public int largestRectangleArea(int[] heights) 
    {
        int maxArea = Integer.MIN_VALUE;
        Stack<Integer> st = new Stack<>();
        int n= heights.length;
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && (i==n ||(heights[st.peek()]>=heights[i])))
            {
                int heightIndex = st.pop();
                int height = heights[heightIndex];
                int width=0;
                if(st.isEmpty())
                    width = i;
                else
                    width = i-st.peek()-1;
                maxArea = Math.max(maxArea,height*width);
            }
            st.push(i);
        }
        while (!st.empty()) {
            int heightIndex = st.peek();
            st.pop();
            int nse = n;
            int pse = (st.empty()) ? -1 : st.peek();
            maxArea = Math.max(maxArea, heights[heightIndex] * (nse - pse - 1));
        }
        return maxArea;
    }
}