//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
		while(t>0)
		{
		    int N = sc.nextInt();
		    int P = sc.nextInt();
		    int prerequisites[][] = new int[P][2];
		    for(int i=0;i<P;i++)
		    {
		        for(int j=0;j<2;j++)
		        {
		            prerequisites[i][j] = sc.nextInt();
		        }
		    }
			Solution ob = new Solution();
			if(ob.isPossible(N,P,prerequisites))
			{
			    System.out.println("Yes");
			}
			else{
			    System.out.println("No");
			}
			t--;
		
System.out.println("~");
}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public boolean isPossible(int V,int P, int[][] prerequisites)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int indegree[] = new int[V];
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer>arr = new ArrayList<>();
        
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<P;i++)
        {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        
        for(int i=0;i<V;i++)
        {
            for(int ad:adj.get(i))
            {
                indegree[ad]++;
            }
        }
        
        for(int i=0;i<V;i++)
        {
            if(indegree[i]==0)
            {
                q.add(i);
            }
        }
        
        while(!q.isEmpty())
        {
            int pop = q.poll();
            arr.add(pop);
            
            for(int it:adj.get(pop))
            {
                indegree[it]--;
                if(indegree[it]==0)
                    q.offer(it);
            }
        }
        
        return arr.size()==V;
    }
    
}