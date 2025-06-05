class Solution 
{
    public int compareVersion(String version1, String version2) 
    {
        String v1[] = version1.split("\\.");
        String v2[] = version2.split("\\.");
        int l1 = v1.length,l2 = v2.length;

        for(int i=0;i<Math.max(l1,l2);i++)
        {
            int c1 = i<l1 ? Integer.parseInt(v1[i]) : 0;
            int c2 = i<l2 ? Integer.parseInt(v2[i]) : 0;
            if(c1>c2)   return 1;
            if(c2>c1)   return -1;
        }
        return 0;
    }
}