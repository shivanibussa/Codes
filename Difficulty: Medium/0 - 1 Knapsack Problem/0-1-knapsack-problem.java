//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        while (testCases-- > 0) {
            int capacity = Integer.parseInt(br.readLine());
            String[] valInput = br.readLine().split(" ");
            String[] wtInput = br.readLine().split(" ");

            int[] val = new int[valInput.length];
            int[] wt = new int[wtInput.length];

            for (int i = 0; i < valInput.length; i++) {
                val[i] = Integer.parseInt(valInput[i]);
            }

            for (int i = 0; i < wtInput.length; i++) {
                wt[i] = Integer.parseInt(wtInput[i]);
            }

            System.out.println(Solution.knapsack(capacity, val, wt));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    static int knapsack(int W, int val[], int wt[]) {
        // code here
        int n = wt.length;
        int dp[] = new int[[W+1];
        for(int j=0;j<=W;j++)
        {
            if(j>=wt[0])
                dp[0][j] = val[0];
        }
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<=W;j++)
            {
                int not_take = 0+dp[i-1][j];
                int take = Integer.MIN_VALUE;
                if(j>=wt[i])
                    take = val[i]+dp[i-1][j-wt[i]];
                    
                dp[i][j] = Math.max(take,not_take);
                
            }
        }
        return dp[n-1][W];
    }
    static int f(int W, int val[],int wt[],int n)
    {
        if(n==0)
        {
            if(W>=wt[0])
                return val[0];
            else
                return 0;
        }
        int not_take = 0+f(W,val,wt,n-1);
        int take = Integer.MIN_VALUE;
        if(W>=wt[n])
            take = val[n]+f(W-wt[n],val,wt,n-1);
            
        return Math.max(take,not_take);
        
    }
}
