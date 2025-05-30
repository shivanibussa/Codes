/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Pair
{
    int val;
    ListNode node;

    Pair(int val,ListNode node)
    {
        this.val = val;
        this.node = node;
    }
}
class Solution 
{
    public ListNode mergeKLists(ListNode[] lists) 
    {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        if(lists.length==0)
            return null;
        if(lists.length==1)
            return lists[0];
        for(int i=0;i<lists.length;i++)
        {
            if(lists[i]!=null)
                pq.offer(new Pair(lists[i].val,lists[i]));
        }

        ListNode dummy = new ListNode(0);
        ListNode root = dummy;

        while(!pq.isEmpty())
        {
            Pair pop = pq.poll();
            int node_val = pop.val;
            ListNode node = pop.node;
            root.next = node;
            if(node.next!=null)
                pq.offer(new Pair(node.next.val,node.next));
            root = root.next;
        }
        return dummy.next;
    }
}