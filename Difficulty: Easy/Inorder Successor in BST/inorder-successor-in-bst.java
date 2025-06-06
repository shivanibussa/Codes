class Solution
{
    public int inorderSuccessor(Node root, Node x) 
    {
        Node curr = root;
        int res = -1;
        while(curr!=null)
        {
            if(curr.data>x.data)
            {
                res = curr.data;
                curr = curr.left;
            }
            else
            {
                curr = curr.right;
            }
        }
        return res;
    }
}