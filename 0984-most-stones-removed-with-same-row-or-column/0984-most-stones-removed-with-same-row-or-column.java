
class DisjointSet{
    
    ArrayList<Integer> size;
    ArrayList<Integer> parent;
    
    DisjointSet(int n)
    {
        size = new ArrayList<>();
        parent = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            size.add(1);
            parent.add(i);
        }
    }
    
    public int findUparent(int node)
    {
        if(node==parent.get(node))
            return node;
        int root = findUparent(parent.get(node));
        parent.set(node,root);
        return root;
    }
    
    public void UnionBySize(int u,int v)
    {
        int ulp_u = findUparent(u);
        int ulp_v = findUparent(v);
        if(ulp_u==ulp_v)
            return;
        if(size.get(ulp_u)<size.get(ulp_v))
        {
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_u)+size.get(ulp_v));
        }
        else
        {
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
        }
    }
}
class Solution {
    public int removeStones(int[][] stones) 
    {
        int maxRow = 0,maxCol = 0,cnt = 0, n = stones.length;
        for(int i=0;i<n;i++)
        {
            maxRow = Math.max(maxRow,stones[i][0]);
            maxCol = Math.max(maxCol,stones[i][1]);
        }
        DisjointSet ds = new DisjointSet(maxRow + maxCol + 2);
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<n;i++)
        {
            int stone_x = stones[i][0];
            int stone_y = stones[i][1]+maxRow+1;
            ds.UnionBySize(stone_x,stone_y);
            hs.add(stone_x);
            hs.add(stone_y);
        }
        
        for(int it:hs)
        {
            if(it==ds.findUparent(it))
                cnt++;
        }
        return n-cnt;
    }
}