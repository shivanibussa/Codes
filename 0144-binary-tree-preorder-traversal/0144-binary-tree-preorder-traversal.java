class Solution 
{
    public List<Integer> preorderTraversal(TreeNode root) 
    {
        List<Integer> res = new ArrayList<>();
        if(root==null)
            return res;
        f(root,res);
        return res;
    }
    public void f(TreeNode root, List<Integer> res)
    {
        if(root==null)
            return;
        
        res.add(root.val);
        f(root.left,res);
        f(root.right,res);
    }
}