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
class BSTIterator {
Stack<TreeNode> st = new Stack<>();;
    public BSTIterator(TreeNode root) 
    {
      pushAllNodes(root);
    }
    public void pushAllNodes(TreeNode root)
    {
        for(;root!=null;root=root.left)
            st.push(root);
    }
    
    public int next() 
    {
        TreeNode pop =st.pop();
        pushAllNodes(pop.right);
        return pop.val;
    }
    
    public boolean hasNext() 
    {
        return !st.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */