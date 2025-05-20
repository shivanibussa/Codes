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
    public void parentsFeed(HashMap<TreeNode,TreeNode> parents,TreeNode root)
    {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty())
        {
            TreeNode pop = q.poll();
            if(pop.left!=null)
            {
                q.add(pop.left);
                parents.put(pop.left,pop);
            }
            if(pop.right!=null)
            {
                q.add(pop.right);
                parents.put(pop.right,pop);
            }
        }
    }
    public int amountOfTime(TreeNode root, int start) 
    {
        HashMap<TreeNode,TreeNode> parents = new HashMap<>();
        HashMap<TreeNode,Boolean> visited = new HashMap<>();
        parentsFeed(parents,root);
        Queue<TreeNode> q = new LinkedList<>();
        int curr = 0;


        q.offer(root);
        TreeNode targetN = null;
        while(!q.isEmpty())
        {
            TreeNode node = q.poll();
            if(node.val==start)
            {
                targetN = node;
                break;
            }
            if(node.left!=null)
            {
                q.offer(node.left);
            }
            if(node.right!=null)
            {
                q.offer(node.right);
            }
        }
        q.clear();

        q.add(targetN);
        while(!q.isEmpty())
        {
            int s = q.size();
            curr++;
            for(int i=0;i<s;i++)
            {
                TreeNode pop = q.poll();
                visited.put(pop,true);

                if(pop.left!=null && visited.get(pop.left)==null)
                {
                    q.offer(pop.left);
                    visited.put(pop.left,true);
                } 
                if(pop.right!=null && visited.get(pop.right)==null)
                {
                    q.offer(pop.right);
                    visited.put(pop.right,true);
                }
                if(parents.get(pop)!=null && visited.get(parents.get(pop))==null)
                {
                    q.offer(parents.get(pop));
                    visited.put(parents.get(pop),true);
                }
            }
        }
        return curr-1;
    }
}