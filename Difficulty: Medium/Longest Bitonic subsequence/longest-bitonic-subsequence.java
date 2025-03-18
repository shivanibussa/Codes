//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
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

            int[] nums = IntArray.input(br, n);

            Solution obj = new Solution();
            int res = obj.LongestBitonicSequence(n, nums);

            System.out.println(res);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends



class Solution 
{
    public static int LongestBitonicSequence(int n, int[] arr) 
    {
        int dp1[] = new int[n];
        int dp2[] = new int[n];
        // int maxi=0;
        for(int i=0;i<n;i++){
            dp1[i] = 1;
            dp2[i] = 1;
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(arr[i]>arr[j] && 1+dp1[j]>dp1[i])
                {
                    dp1[i] = 1+dp1[j];
                }
            }
        }
        if(dp1[arr.length-1] == arr.length) return 0;
        int maxi = 1;
        for(int i=n-1;i>=0;i--)
        {
            for(int j=n-1;j>i;j--)
            {
                if(arr[i]>arr[j] && 1+dp2[j]>dp2[i])
                {
                    dp2[i] = 1+dp2[j];
                    if(dp1[i] != 1 && dp2[i] != 1)
                        maxi = Math.max(maxi, dp1[i]+dp2[i]);
                }
            }
        }
        return maxi-1;
    }
}
