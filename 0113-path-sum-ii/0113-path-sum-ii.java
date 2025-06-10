class Solution 
{
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) 
    {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if(root==null)
            return res;
        f(res,path,root,targetSum,0);
        return res;
    }
    public void f(List<List<Integer>> res, List<Integer> path, TreeNode root, int target,int sum)
    {
        sum+=root.val;
        path.add(root.val);
        boolean isLeaf = root.left==null && root.right==null ? true:false;
        if(isLeaf && sum==target)
        {
            res.add(new ArrayList<>(path));
        }
        else{
        if(root.left!=null)
            f(res,path,root.left,target,sum);
        if(root.right!=null)
            f(res,path,root.right,target,sum);
        }
        path.remove(path.size()-1);
    }
}