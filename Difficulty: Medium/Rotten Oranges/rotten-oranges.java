//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int mat[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) mat[i][j] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(mat);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution 
{
   
    public int orangesRotting(int[][] mat) 
    {
        int r=mat.length,c=mat[0].length;
        int res=0,fresh=0,cnt=0;
        
        Queue<int[]> q = new LinkedList<>();
        int visited[][] = new int[r][c];
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(mat[i][j]==2)
                {
                   q.add(new int[]{i,j,0}); 
                   visited[i][j] = 2;
                }
                else {
                    visited[i][j]=0;
                }
                
                if(mat[i][j]==1)
                {
                    fresh++;
                }
            }
        }
        int tm = 0;
        int dr[] = {-1,0,1,0};
        int dc[] = {0,-1,0,1};
        
        while(!q.isEmpty())
        {
            int pop[] = q.poll();
            int i=pop[0];
            int j=pop[1];
            int time=pop[2];
            res = Math.max(res,time);
            for(int m=0;m<4;m++)
            {
                int nr = i+dr[m];
                int nc = j+dc[m];
                
                if(nr>=0 && nc>=0 && nr<r && nc<c && mat[nr][nc]==1 && visited[nr][nc]!=2)
                {
                    visited[nr][nc]=2;
                    q.offer(new int[]{nr,nc,time+1});
                    cnt++;
                }
            }
        }
        if(cnt!=fresh)
            return -1;
        return res;
    }
}