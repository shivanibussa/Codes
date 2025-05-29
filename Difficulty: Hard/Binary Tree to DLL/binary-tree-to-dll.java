/* class Node
class Node
{
    Node left, right;
    int data;

    Node(int d)
    {
        data = d;
        left = right = null;
    }

}*/

// This function should return head to the DLL

class Solution 
{
    private Node prev;
    private Node head;
    Node bToDLL(Node root) 
    {
        if(root==null)
            return null;
        DFS(root);
        
        // head.left = prev;
        // prev.right = head;
        
        return head;
    }
    public void DFS(Node root)
    {
        if(root!=null)
        {
            DFS(root.left);
        
        if(prev==null)
            head = root;
            
        else
        {
           prev.right = root;
           root.left = prev;
        }
        
        prev = root;
        
        DFS(root.right);
        }
    }
}