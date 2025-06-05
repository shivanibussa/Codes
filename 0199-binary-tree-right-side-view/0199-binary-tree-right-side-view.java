class Solution 
{
    public List<Integer> rightSideView(TreeNode root) 
    {
        ArrayList<Integer> res = new ArrayList<>();
        f(root,res,0);
        return res;
    }
    public void f(TreeNode root,ArrayList<Integer> res,int level)
    {
        if(root==null)
            return;
        
        if(level==res.size())
            res.add(root.val);

        f(root.right,res,level+1);
        f(root.left,res,level+1);
    }
}