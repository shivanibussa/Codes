//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java
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
    
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) 
    {
        DisjointSet ds = new DisjointSet(rows*cols+1);
        int visited[][] = new int[rows][cols];
        ArrayList<Integer> ans = new ArrayList<>();
        int cnt=0;
        int n = operators.length;
        for(int i=0;i<n;i++)
        {
            int r = operators[i][0];
            int c = operators[i][1];
            if(visited[r][c]==1)
            {
                ans.add(cnt);
                continue;
                
            }
           
            cnt++;
            visited[r][c]=1;
            int dr[] = {-1,0,1,0};
            int dc[] = {0,-1,0,1};
            for(int k=0;k<4;k++)
            {
                int nr = dr[k]+r;
                int nc = dc[k]+c;
                
                if(nr>=0 && nc>=0 && nr<rows && nc<cols)
                {
                    if(visited[nr][nc]==1)
                    {
                        int neighbor = nr*cols+nc;
                        int node = r*cols+c;
                        if(ds.findUparent(neighbor)!=ds.findUparent(node))
                        {
                            cnt--;
                            ds.UnionBySize(node,neighbor);
                        }
                        
                    }
                }
            }
            ans.add(cnt);
        }
        
        return ans;
    }
    
}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int  k= sc.nextInt();
            int[][] a = new int[k][2];
            for(int i=0;i<k;i++){
            
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            List<Integer> ans = obj.numOfIslands(n,m,a);
           
            for(int i:ans){
                System.out.print(i+" ");
            }
            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends