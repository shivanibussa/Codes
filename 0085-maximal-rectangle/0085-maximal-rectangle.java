class Solution 
{
    public int maximalRectangle(char[][] mat) 
    {
        int m = mat.length,n=mat[0].length;
        int maxA=0;
        int arr[] = new int[n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(mat[i][j]=='0')
                    arr[j]=0;
                else
                    arr[j]+=1;
            }
            maxA=Math.max(maxA,f(arr));
        }
        return maxA;
    }

    public int f(int arr[])
    {
        int n=arr.length,maxA=0;
        Stack<Integer>st = new Stack<>();
        for(int i=0;i<=arr.length;i++)
        {
            while(!st.isEmpty()&&( i==n || arr[i]<=arr[st.peek()]))
            {
                int height = arr[st.pop()];
                int width =  st.isEmpty()==true?i:i-st.peek()-1;
                int area = height*width;
                maxA = Math.max(maxA,area);
            }
            st.push(i);
        }
        return maxA;
    }
}