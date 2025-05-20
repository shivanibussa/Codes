// User function Template for Java

/*Complete the function below
Node is as follows:
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/
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