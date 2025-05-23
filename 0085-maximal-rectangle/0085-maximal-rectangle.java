class Solution 
{
    public int maximalRectangle(char[][] matrix) 
    {
        int m=matrix.length,n = matrix[0].length,maxA=0;
        int arr[] = new int[n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]=='1')
                {
                    arr[j]++;
                }
                else
                {
                    arr[j]=0;
                }
            }
            maxA = Math.max(maxA,maxArea(arr));
        }
        return maxA;
    }
    public int maxArea(int arr[])
    {
        int n = arr.length,maxA=0;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<=n;i++)
        {
            while(!st.isEmpty() && (i==n|| arr[i]<=arr[st.peek()]))
            {
                int height = arr[st.pop()];
                int width = st.isEmpty()==true? i : (i-st.peek()-1);
                int area = height*width;
                maxA = Math.max(area,maxA);
            }
            st.push(i);
        }
        return maxA;
    }


}