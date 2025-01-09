class Solution 
{
    public int leastInterval(char[] tasks, int n) 
    {
        int freq[] = new int[26];
        for(char c:tasks)
        {
            freq[c-'A']++;
        }
        int maxf = Arrays.stream(freq).max().getAsInt();
        int mc=0;
        for(int f:freq)
        {
            if(f==maxf)
                mc++;
        }
        return Math.max((maxf-1)*(n+1)+mc,tasks.length);
    }
}
