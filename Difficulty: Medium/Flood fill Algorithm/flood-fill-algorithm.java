//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int m = Integer.parseInt(br.readLine().trim());
            int[][] image = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] S2 = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) image[i][j] = Integer.parseInt(S2[j]);
            }
            int sr = Integer.parseInt(br.readLine().trim());
            int sc = Integer.parseInt(br.readLine().trim());
            int newColor = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            int[][] ans = obj.floodFill(image, sr, sc, newColor);
            for (int i = 0; i < ans.length; i++) {
                for (int j = 0; j < ans[i].length; j++)
                    System.out.print(ans[i][j] + " ");
                System.out.println();
            }

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution 
{
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) 
    {
        int rows = image.length,cols=image[0].length;
        int matrix[][] = new int[rows][cols];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                matrix[i][j] =-1;
            }
        }
        int color = image[sr][sc];
        q.add(new int[]{sr,sc,color});
        matrix[sr][sc] = newColor;
        while(!q.isEmpty())
        {
            int poll[] = q.poll();
            int r = poll[0];
            int c = poll[1];
            int col = poll[2];
            
            int dr[] = {-1,0,1,0};
            int dc[] = {0,-1,0,1};
            
            for(int i=0;i<4;i++)
            {
                int nr = r+dr[i];
                int nc = c+dc[i];
                
                if(nr>=0 && nr<rows && nc>=0 && nc<cols && image[nr][nc]==col 
                && matrix[nr][nc]==-1)
                {
                    q.add(new int[]{nr,nc,col});
                    matrix[nr][nc]=newColor;
                }
            }
        }
        
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(matrix[i][j]==-1)
                {
                    matrix[i][j] = image[i][j];
                }
            }
        }
        
        return matrix;
    }
}