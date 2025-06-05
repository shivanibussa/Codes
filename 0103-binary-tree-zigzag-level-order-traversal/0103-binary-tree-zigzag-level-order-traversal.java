class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        boolean reverse = true;
        if(root==null)
            return res;
        q.add(root);
        while(!q.isEmpty())
        {
            reverse = !reverse;
            List<Integer> temp = new ArrayList<>();
            int s = q.size();
            for(int i=0;i<s;i++)
            {
                TreeNode pop = q.poll();
                temp.add(pop.val);
                if(pop.left!=null)
                    q.add(pop.left);
                if(pop.right!=null)
                    q.add(pop.right);
            }
            if(reverse)
                Collections.reverse(temp);
            res.add(temp);
        }
        return res;
         
    }
}