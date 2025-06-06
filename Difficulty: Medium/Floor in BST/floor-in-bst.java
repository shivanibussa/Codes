// User function Template for Java

class Solution {
    public static int floor(Node root, int x) 
    {
        // Code here
        Node curr = root;
        if(root==null)
            return -1;
        int floor = -1;
        while(curr!=null)
        {
            if(curr.data==x)
                return x;
            if(curr.data<x)
            {
                floor = curr.data;
                curr = curr.right;
            }
            else
            {
                curr = curr.left;
            }
        }
        return floor;
        
    }
}