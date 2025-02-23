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
    public List<Integer> rightSideView(TreeNode root) 
    {
        ArrayList<Integer> arr = new ArrayList<>();
        if(root==null)
            return arr;
        f(root,0,arr);
        return arr;
    }
    public void f(TreeNode node,int level,List<Integer> res)
    {
        if(node==null)
            return;
        if(level==res.size())
            res.add(node.val);
        f(node.right,level+1,res);
        f(node.left,level+1,res);
    }
}