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
    public List<String> binaryTreePaths(TreeNode root) 
    {
        ArrayList<ArrayList<Integer>> resz = new ArrayList<>();
        f(root,new ArrayList<Integer>(),resz);
        //  System.out.println(resz);
        return Stringify(resz);
    }
    public static void f(TreeNode root,ArrayList<Integer> path, 
    ArrayList<ArrayList<Integer>> res)
    {
        if(root==null)
            return;
        path.add(root.val);
        if(root.left==null && root.right==null)
            res.add(new ArrayList<>(path));

        f(root.left,path,res);
        f(root.right,path,res);
        path.remove(path.size()-1);
    }
    public static List<String> Stringify(ArrayList<ArrayList<Integer>> resz)
    {
        
        List <String>res = new ArrayList<>();
        // System.out.println(resz);
        for(int i=0;i<resz.size();i++)
        {
            String ans="";
            for(int num:resz.get(i))
            {
                ans+=String.valueOf(num)+"->";
            }
            ans=ans.substring(0,ans.length()-2);
            res.add(ans);
        }
        // ans=ans.subString(0,ans.length()-1);
        System.out.println(res);
        return res;
    }
}