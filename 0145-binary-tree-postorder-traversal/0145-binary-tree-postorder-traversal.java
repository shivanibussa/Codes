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
    public List<Integer> postorderTraversal(TreeNode root) 
    {
        Stack<TreeNode> st1 = new Stack<>();
        ArrayList<Integer> al = new ArrayList<>();
        if(root==null)
            return al;
        st1.push(root);
        while(!st1.isEmpty())
        {
            TreeNode pop = st1.pop();
            al.add(pop.val);
            if(pop.left!=null)
                st1.add(pop.left);
            if(pop.right!=null)
                st1.add(pop.right);
        }
        Collections.reverse(al);
        return al;
    }
}