//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++) mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int rows;
            rows = Integer.parseInt(br.readLine());

            int columns;
            columns = Integer.parseInt(br.readLine());

            int[][] heights = IntMatrix.input(br, rows, columns);

            Solution obj = new Solution();
            int res = obj.MinimumEffort(rows, columns, heights);

            System.out.println(res);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends



class Solution 
{
    public static int MinimumEffort(int m, int n, int[][] heights) 
    {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int dist[][] = new int[m][n];
        int dr[] = {-1,0,1,0};
        int dc[] = {0,-1,0,1};
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0] =0;
        pq.offer(new int[]{0,0,0});
        while(!pq.isEmpty())
        {
            int pop[] = pq.poll();
            int diff = pop[0];
            int x = pop[1];
            int y = pop[2];
            if(x==m-1 && y==n-1)
                return diff;
            for(int i=0;i<4;i++)
            {
                int nr = x+dr[i];
                int nc = y+dc[i];
                if(nr>=0 && nr<m && nc>=0 && nc<n)
                {
                    int newEffort = Math.max(diff,Math.abs(heights[x][y]-heights[nr][nc]));
                    if(newEffort<dist[nr][nc])
                    {
                        dist[nr][nc] = newEffort;
                        pq.add(new int[]{newEffort,nr,nc});
                    }
                }
            }
        }
        return 0;
    }
}
