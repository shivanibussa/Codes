class Solution 
{
    ArrayList<Integer> boundaryTraversal(Node root) 
    {
        ArrayList<Integer> res = new ArrayList<>();
        if(root==null)
            return res;
        if(!isLeaf(root))
        res.add(root.data);
        
        addLeftBoundary(root,res);
        addLeaves(root,res);
        addRightBoundary(root,res);
        return res;
    }
    public void addLeftBoundary(Node root,ArrayList<Integer> res)
    {
        Node curr = root.left;
        while(curr!=null)
        {
            if(!isLeaf(curr))
            {
                res.add(curr.data);
            }
                if(curr.left!=null)
                {
                    curr = curr.left;
                }
                else
                {
                    curr = curr.right;
                }
            
        }
    }
    public void addRightBoundary(Node root,ArrayList<Integer> res)
    {
        Node curr = root.right;
        ArrayList<Integer> temp = new ArrayList<>();
        while(curr!=null)
        {
            if(!isLeaf(curr))
            {
                temp.add(curr.data);
            }
                if(curr.right!=null)
                {
                    curr = curr.right;
                }
                else
                {
                    curr=curr.left;
                }
            
        }
        Collections.reverse(temp);
        res.addAll(temp);
    }
    
    public void addLeaves(Node root,ArrayList<Integer> res)
    {
        if(root==null)
            return;
        if(isLeaf(root)){
            res.add(root.data);
            return;
        }
        addLeaves(root.left,res);
        addLeaves(root.right,res);
    }
    
    public boolean isLeaf(Node node)
    {
        if(node.left==null && node.right==null)
            return true;
        else
            return false;
    }
    
}