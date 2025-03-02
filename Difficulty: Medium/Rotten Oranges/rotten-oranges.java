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
        int rows = mat.length,cols = mat[0].length;
        int rot[][] = new int[rows][cols];
        int fresh=0,spoiled=0,time=0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(mat[i][j]==2)
                {
                    q.add(new int[]{i,j,0});
                    rot[i][j] = 2;
                }
                else if(mat[i][j]==1)
                {
                    fresh++;
                }
            }
        }
        while(!q.isEmpty())
        {
            int poll[] = q.poll();
            int r = poll[0];
            int c = poll[1];
            int t = poll[2];
            time = t;
            
            int dr[] = {-1,0,1,0};
            int dc[] = {0,-1,0,1};
            
            for(int i=0;i<4;i++)
            {
                int nr = r+dr[i];
                int nc = c+dc[i];
                
                if(nr>=0 && nr<rows && nc>=0 && nc<cols && 
                mat[nr][nc]==1 && rot[nr][nc]==0)
                {
                    rot[nr][nc]=2;
                    q.add(new int[]{nr,nc,t+1});
                    spoiled++;
                }
            }
        }
        if(fresh==spoiled)
            return time;
        else
            return -1;
        
    }
}