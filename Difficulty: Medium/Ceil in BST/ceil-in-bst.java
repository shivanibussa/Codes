// User function Template for Java

class Tree 
{
    int findCeil(Node root, int key) 
    {
        if (root == null) return -1;
        int ceil = -1;
        while(root!=null)
        {
            if(root.data==key)
                return root.data;
                
            if(root.data < key)
            {
                root = root.right; 
            }
            else
            {
                ceil = root.data;
                root = root.left;
            }
        }
        return ceil;
    }
}
