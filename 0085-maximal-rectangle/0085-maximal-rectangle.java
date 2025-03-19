class Solution 
{
    public int maxArea(int arr[])
    {
        Stack<Integer> st = new Stack<>();
        int maxArea = Integer.MIN_VALUE;
        int n= arr.length;
        for(int i=0;i<=n;i++)
        {
            while(!st.isEmpty() && (i==n||arr[st.peek()]>=arr[i]))
            {
                int height = arr[st.pop()];
                int width = 0;
                if(st.isEmpty())
                    width=i;
                else
                    width = i-st.peek()-1;

                maxArea = Math.max(maxArea,height*width);
            }
            st.push(i);
        }
        return maxArea;
    }
    public int maximalRectangle(char[][] matrix) 
    {
        int n = matrix[0].length;
        int arr[] = new int[n];
        int maxArea = Integer.MIN_VALUE;
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]=='1')
                    arr[j]++;
                else
                    arr[j]=0;
            }
            maxArea = Math.max(maxArea,maxArea(arr));
        }
        return maxArea;
    }
}
