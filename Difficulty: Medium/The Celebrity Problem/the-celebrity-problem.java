class Solution 
{
    public int celebrity(int mat[][]) 
    {
        int n = mat.length;
        int i=0,j=n-1;
        while(i<j)
        {
            if(mat[j][i]==1)
                j--;
            else
            i++;
        }
        int c = i;
        
        for(int ii=0;ii<n;ii++)
        {
            if(ii==c)
                continue;
            
            if(mat[c][ii]!=0 || mat[ii][c]==0)
                return -1;
        }
        return c;
    }
}