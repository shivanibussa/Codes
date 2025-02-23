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
class Pair
{
    TreeNode node;
    int id;
    Pair(TreeNode node, int id)
    {
        this.node=node;
        this.id=id;
    }
}
class Solution 
{
    public int widthOfBinaryTree(TreeNode root) 
    {
        int maxW=0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty())
        {
            int size = q.size();
            int mmin = q.peek().id;
            int f=0,l=0;
            for(int i=0;i<size;i++)
            {
                Pair pop = q.poll();
                TreeNode node = pop.node;
                int curr_id = pop.id-mmin;
                if(i==0)f=curr_id;
                if(i==size-1)l=curr_id;
                if(node.left!=null)
                {
                    q.offer(new Pair(node.left,((2*curr_id)+1)));
                }
                if(node.right!=null)
                {
                    q.offer(new Pair(node.right,((2*curr_id)+2)));
                }
            }
            maxW = Math.max(maxW,l-f+1);
        }
        return maxW;
    }
}