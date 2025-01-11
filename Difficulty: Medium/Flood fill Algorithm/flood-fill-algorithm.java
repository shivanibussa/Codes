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
    public int[][] floodFill(int[][] image, int sr, int sc, int newcolor) 
    {
        int oldcolor = image[sr][sc];
        if(oldcolor!=newcolor)
            helper(oldcolor,newcolor,sr,sc,image);
        return image;
    }
    public void helper(int oldcolor, int newcolor, int r,int c, int[][] image)
    {
        int rows = image.length;
        int cols = image[0].length;
        if(r>=0 && c>=0 && r<rows && c<cols && image[r][c]==oldcolor)
            image[r][c] = newcolor;
        
        
        
        int dr[]={-1,0,1,0};
        int dc[]={0,-1,0,1};
        
        for(int i=0;i<4;i++)
        {
            int nr = r+dr[i];
            int nc = c+dc[i];
            
            if(nr>=0 && nc>=0 && nr<rows && nc<cols && image[nr][nc]==oldcolor)
            {
                image[nr][nc]=newcolor;
                helper(oldcolor,newcolor,nr,nc,image);
            }
        }
    }
}