//{ Driver Code Starts

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases

        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            int[] a = new int[input.length]; // Change long to int

            for (int i = 0; i < input.length; i++) {
                a[i] = Integer.parseInt(
                    input[i]); // Change Long.parseLong to Integer.parseInt
            }

            Solution ob = new Solution();
            System.out.println(
                ob.minCost(a)); // Ensure minCost accepts int[] as argument
        }
    }
}

// } Driver Code Ends


class Solution 
{
    public int minCost(int[] arr) 
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int minS = 0;
        for(int i=0;i<arr.length;i++)
        {
            pq.add(arr[i]);
        }
        while(pq.size()>=2)
        {
            int a = pq.poll();
            int b = pq.poll();
            minS=minS+a+b;
            pq.offer(a+b);
        }
        return minS;
    }
}