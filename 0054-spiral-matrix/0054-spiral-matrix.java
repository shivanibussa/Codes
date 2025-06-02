class Solution 
{
    public List<Integer> spiralOrder(int[][] matrix) 
    {
        int r = matrix.length, c = matrix[0].length;
        int si=0, ei = r-1, sj =0, ej = c-1, dir=0;
        ArrayList<Integer> ans = new ArrayList<>();
        while(si<=ei && sj<=ej)
        {
            if(dir==0)
            {
                for(int j=sj;j<=ej;j++)
                {
                    ans.add(matrix[si][j]);
                }
                si+=1;
            }
            else if( dir ==1)
            {
                for(int i=si;i<=ei;i++)
                {
                    ans.add(matrix[i][ej]);
                }
                ej-=1;
            }
            else if(dir ==2)
            {
                for(int j=ej;j>=sj;j--)
                {
                    ans.add(matrix[ei][j]);
                }
                ei-=1;
            }
            else
            {
                for(int i=ei;i>=si;i--)
                {
                    ans.add(matrix[i][sj]);
                }
                sj+=1;
            }
            dir = (dir+1)%4;
        }
        return ans;
    }
}