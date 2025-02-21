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
    public List<Integer> f(TreeNode root,List<Integer> al)
    {
        if(root==null)
            return al;
        al.add(root.val);
        f(root.left,al);
        f(root.right,al);
        return al;
    }
    public List<Integer> preorderTraversal(TreeNode root)
    {
        List<Integer> al = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        if(root==null)
            return al;
        st.push(root);
        while(!st.isEmpty())
        {
            TreeNode pop = st.pop();
            al.add(pop.val);
            if(pop.right!=null)
                st.add(pop.right);
            if(pop.left!=null)
                st.add(pop.left);
        }
        return al;
    }
}