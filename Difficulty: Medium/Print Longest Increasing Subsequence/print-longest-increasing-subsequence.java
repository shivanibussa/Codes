//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            String str[] = br.readLine().split(" ");
            int arr[] = new int[str.length];

            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            Solution obj = new Solution();

            ArrayList<Integer> ans = obj.getLIS(arr);
            for (int i = 0; i < ans.size(); i++) {
                System.out.print(ans.get(i) + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public ArrayList<Integer> getLIS(int nums[]) {
        // Code here
        int n = nums.length,lastIndex=0;
        int dp[] = new int[n],maxi=1;
        int hash[] = new int[n];
        for(int i=0;i<n;i++)
        {
            dp[i] = 1;
            hash[i] = i;
        }
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[i]>nums[j] && 1+dp[j]>dp[i])
                {
                    dp[i] = 1+dp[j];
                    hash[i] = j;
                }
            }
            if(dp[i]>maxi)
            {
                maxi = dp[i];
                lastIndex = i;
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        res.add(nums[lastIndex]);
        while(lastIndex!=hash[lastIndex])
        {
            lastIndex = hash[lastIndex];
            res.add(nums[lastIndex]);
        }
        Collections.reverse(res);
        return res;
    }
}
