/* class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
} */

class Tree 
{
    int findCeil(Node root, int key) 
    {
        if(root==null)
            return -1;
        Node curr = root;
        int ceil = -1;
        while(curr!=null)
        {
            if(curr.data==key)
                return curr.data;
            if(curr.data<key)
            {
               curr = curr.right;
            }
            else
            {
                ceil = curr.data;
                 curr = curr.left;
                
            }
        }
        return ceil;
    }
}