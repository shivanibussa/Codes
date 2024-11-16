/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void parentFeed(TreeNode root, HashMap<TreeNode, TreeNode> hm, TreeNode target)
    {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty())
        {
            TreeNode curr = q.poll();
            if(curr.left!=null)
            {
                hm.put(curr.left,curr);
                q.offer(curr.left);
            }
            if(curr.right!=null)
            {
                hm.put(curr.right,curr);
                q.offer(curr.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) 
    {
        HashMap<TreeNode, TreeNode> hm = new HashMap<>();
        parentFeed(root, hm, target);
        HashMap<TreeNode,Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        visited.put(target,true);
        int curr_l=0;
        while(!q.isEmpty())
        {
            int size = q.size();
            if(curr_l==k)
                break;
            curr_l++;
            for(int i=0;i<size;i++)
            {
                TreeNode curr = q.poll();
                if(curr.left!=null && visited.get(curr.left)==null)
                {
                    q.offer(curr.left);
                    visited.put(curr.left, true);
                }
                if(curr.right!=null && visited.get(curr.right)==null)
                {
                    q.offer(curr.right);
                    visited.put(curr.right,true);
                }
                if(hm.get(curr)!=null && visited.get(hm.get(curr))==null)
                {
                    q.offer(hm.get(curr));
                    visited.put(hm.get(curr),true);
                }
            }
            
        }
        ArrayList<Integer> al = new ArrayList<>();
        while(!q.isEmpty())
        {
            TreeNode p = q.poll();
            al.add(p.val);
        }
        return al;
    }
}