/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution 
{
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) 
    {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if(root==null)
            return res;
        f(root,path,res,targetSum,0);
        return res;
    }
    public void f(TreeNode root,List<Integer>path,List<List<Integer>> res,int target,int sum)
    {

        sum+=root.val;
        path.add(root.val);
        boolean isLeaf = (root.left==null && root.right==null) ? true:false;
        if(sum==target && isLeaf)
        {
            res.add(new ArrayList<>(path));
        }
        if(root.left!=null)
            f(root.left,path,res,target,sum);
        if(root.right!=null)
            f(root.right,path,res,target,sum);

        path.remove(path.size()-1);
    }
}