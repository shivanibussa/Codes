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
        f(root.left,al);
        al.add(root.val);
        f(root.right,al);
        return al;
    }
    public List<Integer> inorderTraversal(TreeNode root)
    {
       List<Integer> al = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        if(root==null)
            return al;
        TreeNode node = root;
        while(true)
        {
            if(node!=null)
            {
                st.push(node);
                node=node.left;
            }
            else
            {
                if(st.isEmpty())
                    break;
                node = st.pop();
                al.add(node.val);
                node=node.right;
            }
        }
        return al;
    }
}