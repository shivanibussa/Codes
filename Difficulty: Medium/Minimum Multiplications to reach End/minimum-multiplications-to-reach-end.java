//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution 
{
    int minimumMultiplications(int[] arr, int src, int end) 
    {
        
        if(src==end)
            return 0;
        Queue<int[]> q = new LinkedList<>();
        int dist[] = new int[100000];
        for(int i=0;i<100000;i++)
        {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src]=0;
        q.offer(new int[]{src,0});
        int mod = 100000;
        
        while(!q.isEmpty())
        {
            int pop[] = q.poll();
            int a = pop[0];
            int steps = pop[1];
            
            for(int i=0;i<arr.length;i++)
            {
                int pro = (a*arr[i])%mod;
                if(dist[pro]>1+steps)
                {
                    dist[pro]=1+steps;
                    if(pro==end)
                    {
                        return 1+steps;
                    }
                    q.offer(new int[]{pro,steps+1});
                }
            }
        }
        return -1;
    }
}
