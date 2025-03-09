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
    int minimumMultiplications(int[] arr, int start, int end) 
    {
        if(start==end)
            return 0;
        int dist[] = new int[100000];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start,0});
        for(int i=0;i<100000;i++)
        {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;
        
        int mod = 100000;
        while(!q.isEmpty())
        {
            int pop[] = q.poll();
            int a = pop[0];
            int s = pop[1];
            for(int i=0;i<arr.length;i++)
            {
                int pro = (a*arr[i])%mod;
                if(dist[pro]>1+s)
                {
                    dist[pro] = 1+s;
                    if(pro==end)
                        return dist[pro];
                    q.add(new int[]{pro,dist[pro]});
                }
            }
        }
        return -1;
        
    }
}
