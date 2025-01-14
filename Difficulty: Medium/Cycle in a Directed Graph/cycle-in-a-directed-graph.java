//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++) list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution 
{
    
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int n = adj.size();
        int indegree[] = new int[n];
        ArrayList<Integer> res= new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            for(int it:adj.get(i))
            {
                indegree[it]++;
            }
        }
        for(int i=0;i<n;i++)
        {
            if(indegree[i]==0)
                q.offer(i);
        }
        
        while(!q.isEmpty())
        {
            int pop = q.poll();
            res.add(pop);
            
            for(int nn:adj.get(pop))
            {
                indegree[nn]--;
                if(indegree[nn]==0)
                {
                    q.offer(nn);
                }
            }
            
        }
        return res.size()!=V;
        
    }
    
}