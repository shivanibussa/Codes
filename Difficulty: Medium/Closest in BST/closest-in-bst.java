class Solution {
    static int minDiff(Node root, int K) {
        int closest = root.data;
        Node curr = root;
        
        while (curr != null) {
            int currDiff = Math.abs(curr.data - K);
            int closestDiff = Math.abs(closest - K);
            
            // Update closest if current node is closer
            if (currDiff < closestDiff || 
                (currDiff == closestDiff && curr.data < closest)) {
                closest = curr.data;
            }
            
            // Traverse left/right based on K's value
            if (K < curr.data) {
                curr = curr.left;
            } else if (K > curr.data) {
                curr = curr.right;
            } else {
                break; // Exact match found
            }
        }
        return Math.abs(closest - K); // Return minimum difference
    }
}
