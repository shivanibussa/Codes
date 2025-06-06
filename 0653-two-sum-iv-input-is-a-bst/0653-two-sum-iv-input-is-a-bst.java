class BSTIterator {
Stack<TreeNode> st = new Stack<>();
boolean reverse;
    public BSTIterator(TreeNode root,boolean isreverse) 
    {
      reverse = isreverse;
      pushAllNodes(root);
    }
    public void pushAllNodes(TreeNode root)
    {
        if(reverse==false)
        {
            for(;root!=null;root=root.left)
                st.push(root);
        }
        else
        {
            for(;root!=null;root=root.right)
                st.push(root);
        }
    }
    
    public int next() 
    {
        TreeNode pop =st.pop();
        if(reverse==false)
            pushAllNodes(pop.right);
        else
            pushAllNodes(pop.left);
        return pop.val;
    }
    
    public boolean hasNext() 
    {
        return !st.isEmpty();
    }
}

class Solution
{
    public boolean findTarget(TreeNode root, int k)
    {
        if(root==null)
            return false;
        BSTIterator l = new BSTIterator(root,false);
        BSTIterator r = new BSTIterator(root,true);

        int i = l.next();
        int j = r.next();
        while(i<j)
        {
            if(i+j<k)
                i = l.next();
            else if(i+j>k)
                j = r.next();
            else
                return true;
        }
        return false;
    }
}