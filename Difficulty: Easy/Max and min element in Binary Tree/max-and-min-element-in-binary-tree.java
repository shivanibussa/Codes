// User function Template for Java

/*
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
}
*/
class Solution 
{
    public static int findMax(Node root) 
    {
        int maxNum = Integer.MIN_VALUE;
        while(root!=null)
        {
            maxNum = Math.max(maxNum,root.data);
            if(root.right!=null)
                root=root.right;
            else
                root=root.left;
        }
        return maxNum;
    }

    public static int findMin(Node root) 
    {
        
        int minNum = Integer.MAX_VALUE;
        while(root!=null)
        {
            minNum = Math.min(minNum,root.data);
            if(root.left!=null)
                root=root.left;
            else
                root=root.right;
        }
        return minNum;
    }
}