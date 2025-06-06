class Triplet
{
    int minV;
    int maxV;
    int maxS;
    Triplet(int maxV,int minV,int maxS)
    {
        this.maxV = maxV;
        this.minV = minV;
        this.maxS = maxS;
    }
}
class Solution
{
    static Triplet f(Node root)
    {
        if(root==null)
            return new Triplet(Integer.MIN_VALUE,Integer.MAX_VALUE,0);
        Triplet left = f(root.left);
        Triplet right = f(root.right);
        
        if(left.maxV<root.data && root.data<right.minV)
            return new Triplet(Math.max(root.data,right.maxV),Math.min(root.data,left.minV),left.maxS+right.maxS+1);
        else
            return new Triplet(Integer.MAX_VALUE,Integer.MIN_VALUE,Math.max(left.maxS,right.maxS));
        
    }
    static int largestBst(Node root) 
    {
        return f(root).maxS;
    }
}