// User function Template for Java

// class Node
// {
//     int data;
//     Node left, right;

//     public Node(int d)
//     {
//         data = d;
//         left = right = null;
//     }
// }
class Triplet
{
    public int maxV,minV,maxS;
    
    Triplet(int maxV,int minV,int maxS)
    {
        this.maxV = maxV;
        this.minV = minV;
        this.maxS = maxS;
    }
}
class Solution {

    static Triplet bstHelper(Node root)
    {
        if(root==null)
            return new Triplet(Integer.MIN_VALUE,Integer.MAX_VALUE,0);
            
        Triplet left = bstHelper(root.left);
        Triplet right = bstHelper(root.right);
        
        if(left.maxV < root.data && root.data<right.minV)
        {
            return new Triplet(Math.max(root.data,right.maxV),Math.min(root.data,left.minV),left.maxS+right.maxS+1);
        }
        
        else
            return new Triplet(Integer.MAX_VALUE,Integer.MIN_VALUE,Math.max(left.maxS,right.maxS));
    }
    static int largestBst(Node root) {
        return bstHelper(root).maxS;
        
    }
}