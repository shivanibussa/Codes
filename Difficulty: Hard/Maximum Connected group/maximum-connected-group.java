//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] grid = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution obj = new Solution();
            int ans = obj.MaxConnection(grid);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends

class DisjointSet
{
    ArrayList<Integer> parent = new ArrayList<>();
    ArrayList<Integer> size = new ArrayList<>();
    DisjointSet(int n)
    {
        for(int i=0;i<n;i++)
        {
            parent.add(i);
            size.add(1);
        }
    }
    
    public int findUparent(int node)
    {
        if(node==parent.get(node))
        {
            return node;
        }
        parent.set(node,findUparent(parent.get(node)));
        return parent.get(node);
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
            size.set(ulp_v,(size.get(ulp_u)+size.get(ulp_v)));
        }
        else
        {
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u,(size.get(ulp_u)+size.get(ulp_v)));
        }
    }
    
    
}
class Solution 
{
    public int MaxConnection(int grid[][]) 
    {
        
        int m = grid.length;
        int n = grid[0].length;
        DisjointSet ds = new DisjointSet(m*n);
        int max = 0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1)
                {
                    int cell = i*n+j;
                    int dr[] = {-1,0,1,0};
                    int dc[] = {0,-1,0,1};
                    for(int k=0;k<4;k++)
                    {
                        int nr = dr[k]+i;
                        int nc = dc[k]+j;
                        
                        if(nr>=0 && nc>=0 && nr<m && nc<n)
                        {
                            if(grid[nr][nc]==1)
                            {
                                int neighbor = nr*n+nc;
                                
                                if(ds.findUparent(neighbor)!=ds.findUparent(cell))
                                {
                                    ds.UnionBySize(cell,neighbor);
                                }
                                
                            }
                        }
                    }
                }
            }
        }
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         if (grid[i][j] == 1) {
        //             int parent = ds.findUparent(i * n + j);
        //             max = Math.max(max, ds.size.get(parent)); // Update `max` with the largest connected component size
        //         }
        //     }
        // }
        for(int i=0;i<ds.size.size();i++)
        max = Math.max(max,ds.size.get(i));
        
        int cnt=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                cnt=0;
                if(grid[i][j]==0)
                {
                    int dr[] = {-1,0,1,0};
                    int dc[] = {0,-1,0,1};
                    HashSet<Integer> parents = new HashSet<>();
                    for(int k=0;k<4;k++)
                    {
                        int nr = dr[k]+i;
                        int nc = dc[k]+j;
                        
                        if(nr>=0 && nc>=0 && nr<m && nc<n)
                        {
                            if(grid[nr][nc]==1)
                            {
                                int neighbor = nr*n+nc;
                                int parent = ds.findUparent(neighbor);
                                if(!parents.contains(parent))
                                {
                                    parents.add(parent);
                                    cnt+= ds.size.get(parent);
                                }
                            }
                        }
                    }
                    cnt+=1;
                    max = Math.max(cnt,max);
                }
            }
            
        }
        return max;
    }
    
}