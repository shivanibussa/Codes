/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution 
{
    public void parentFeed(HashMap<TreeNode,TreeNode> parents,TreeNode root)
    {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty())
        {
            TreeNode node = q.poll();
            if(node.left!=null)
            {
                q.offer(node.left);
                parents.put(node.left,node);
            }
            if(node.right!=null)
            {
                q.offer(node.right);
                parents.put(node.right,node);
            }
        }
        for(Map.Entry<TreeNode,TreeNode> es:parents.entrySet())
        {
            System.out.println(es.getKey().val+"->"+es.getValue().val);
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) 
    {
        HashMap<TreeNode,TreeNode> parents = new HashMap<>();
        parentFeed(parents,root);
        ArrayList<Integer> res = new ArrayList<>();
        int curr=0;
        Queue<TreeNode> q = new LinkedList<>();
        HashMap<TreeNode,Boolean> visited = new HashMap<>();
        q.offer(target);
        visited.put(target,true);
        while(!q.isEmpty())
        {
            int size=q.size();
            if(curr==k)
                break;
            curr++;
            for(int i=0;i<size;i++)
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
        while(!q.isEmpty())
        {
            TreeNode p = q.poll();
            res.add(p.val);
        }

        return res;
    }
}