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


class Solution 
{
    static int knapsack(int W, int val[], int wt[]) 
    {
        int n = val.length;
        int dp[][] = new int[n][W+1];
        for(int i=0;i<=W;i++)
        {
            if(i>=wt[0])
            {
                dp[0][i] = val[0];
            }
        }
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<=W;j++)
            {
                int not_take = dp[i-1][j];
                int take = Integer.MIN_VALUE;
                if(j>=wt[i])
                    take = val[i]+dp[i-1][j-wt[i]];
                    
                dp[i][j] = Math.max(take,not_take);
            }
        }
        return dp[n-1][W];
    }
}
