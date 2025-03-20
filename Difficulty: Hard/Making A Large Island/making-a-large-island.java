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

            int n;
            n = Integer.parseInt(br.readLine());

            int[][] grid = IntMatrix.input(br, n, n);

            Solution obj = new Solution();
            int res = obj.largestIsland(grid);

            System.out.println(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends

class DisjointSet{
    
    ArrayList<Integer> size;
    ArrayList<Integer> parent;
    
    DisjointSet(int n)
    {
        size = new ArrayList<>();
        parent = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            size.add(1);
            parent.add(i);
        }
    }
    
    public int findUparent(int node)
    {
        if(node==parent.get(node))
            return node;
        int root = findUparent(parent.get(node));
        parent.set(node,root);
        return root;
    }
    
    public void UnionBySize(int u,int v)
    {
        int ulp_u = findUparent(u);
        int ulp_v = findUparent(v);
        if(ulp_u==ulp_v)
            return;
        if(size.get(ulp_u)<size.get(ulp_v))
        {
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_u)+size.get(ulp_v));
        }
        else
        {
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
        }
    }
}
class Solution 
{
    public int largestIsland(int[][] grid) 
    {
        int m = grid.length,n=grid[0].length;
        DisjointSet ds = new DisjointSet(m*n);
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==0)
                    continue;
                else
                {
                    int dr[] = {-1,0,1,0};
                    int dc[] = {0,-1,0,1};
                    
                    for(int k=0;k<4;k++)
                    {
                        int nr = i+dr[k];
                        int nc = j+dc[k];
                        
                        if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==1)
                        {
                            int cell = i*n+j;
                            int adjCell = nr*n+nc;
                            
                            ds.UnionBySize(cell,adjCell);
                            
                        }
                    }
                }
            }
        }
        
        int maxCount=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                HashSet<Integer> hs = new HashSet<>();
                if(grid[i][j]==1)
                    continue;
                else
                {
                    int dr[] = {-1,0,1,0};
                    int dc[] = {0,-1,0,1};
                    
                    for(int k=0;k<4;k++)
                    {
                        int nr = i+dr[k];
                        int nc = j+dc[k];
                        
                        if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc] == 1)
                        {
                            int cell = i*n+j;
                            int adjCell = nr*n+nc;
                            hs.add(ds.findUparent(adjCell));
                        }
                    }
                    int tot=0;
                    for(int ele:hs)
                    {
                        tot+=ds.size.get(ele);
                    }
                    maxCount = Math.max(maxCount,1+tot);
                }
            }
        }
        
        for(int i=0;i<m*n;i++)
        {
            maxCount = Math.max(maxCount,ds.size.get(ds.findUparent(i)));
        }
        return maxCount;
    }
}
