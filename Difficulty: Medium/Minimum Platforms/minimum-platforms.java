// User function Template for Java

class Solution 
{
    static int findPlatform(int arr[], int dep[]) 
    {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int maxCnt=0,cnt=0;
        int l=0,r=0,n=arr.length;
        while(l<n)
        {
            if(arr[l]<=dep[r])
            {
                l=l+1;
                cnt=cnt+1;
            }
            else
            {
                r =r+1;
                cnt =cnt-1;
            }
            
            maxCnt = Math.max(maxCnt,cnt);
        }
        return maxCnt;
    }
}
