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
    public List<Integer> preorderTraversal(TreeNode root) 
    {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        if(root==null)
            return res;
        st.add(root);
        while(!st.isEmpty())
        {
            TreeNode pop = st.pop();
            res.add(pop.val);
            if(pop.right!=null)
                st.add(pop.right);
            if(pop.left!=null)
                st.add(pop.left);
        }
        return res;
    }
    public void preorder(TreeNode root,ArrayList<Integer> res)
    {
        if(root==null)
            return;
        res.add(root.val);
        preorder(root.left,res);
        preorder(root.right,res);
    }
}