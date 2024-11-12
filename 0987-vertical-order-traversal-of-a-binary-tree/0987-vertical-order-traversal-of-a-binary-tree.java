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
import java.util.*;

class Tuple {
    TreeNode node;
    int row;
    int col;

    public Tuple(TreeNode node, int row, int col) {
        this.node = node;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // Using TreeMap to keep x-coordinates sorted automatically
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> tm = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();

        // Start BFS traversal
        q.offer(new Tuple(root, 0, 0));
        
        while (!q.isEmpty()) {
            Tuple tuple = q.poll();
            TreeNode node = tuple.node;
            int x = tuple.row;
            int y = tuple.col;

            // Initialize TreeMap for x if not present
            tm.computeIfAbsent(x, k -> new TreeMap<>());
            // Initialize List for y-coordinate within x if not present
            tm.get(x).computeIfAbsent(y, k -> new ArrayList<>());
            
            // Add the node's value to the List at (x, y)
            tm.get(x).get(y).add(node.val);

            // Add left and right children to the queue with updated coordinates
            if (node.left != null) {
                q.offer(new Tuple(node.left, x - 1, y + 1));
            }
            if (node.right != null) {
                q.offer(new Tuple(node.right, x + 1, y + 1));
            }
        }

        // Collect the results from tm into ans
        List<List<Integer>> ans = new ArrayList<>();
        for (TreeMap<Integer, List<Integer>> ys : tm.values()) {
            List<Integer> col = new ArrayList<>();
            for (List<Integer> nodes : ys.values()) {
                // Sort the list of nodes at each coordinate to simulate priority queue behavior
                Collections.sort(nodes);
                col.addAll(nodes);
            }
            ans.add(col);
        }

        return ans;
    }
}
