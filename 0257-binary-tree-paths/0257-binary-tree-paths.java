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
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        f(root,path,ans);
        return ans;
    }
    public void f(TreeNode root,List<String> path,List<String> ans)
    {
        if(root==null)
            return;
        
        path.add(String.valueOf(root.val));
        if(root.left==null && root.right==null)
            ans.add(String.join("->",path));
        
        else
        {
            f(root.left,path,ans);
            f(root.right,path,ans);
        }
        path.remove(path.size()-1);

    }
}