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
class Solution 
{
    public ListNode mergeKLists(ListNode[] lists) 
    {
        if(lists.length==0)
            return null;
        if(lists.length==1)
            return lists[0];

        ListNode merged = merge2(lists[0],lists[1]);
        for(int i=2;i<lists.length;i++)
        {
            merged = merge2(merged,lists[i]);
        }
        return merged;
    }

    public ListNode merge2(ListNode l1,ListNode l2)
    {
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;

        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode root = dummy;
        while(temp1!=null && temp2!=null)
        {
            if(temp1.val<temp2.val)
            {
                root.next = temp1;
                temp1 = temp1.next;
            }
            else
            {
                root.next = temp2;
                temp2 = temp2.next;
            }
            root = root.next;
        }
        if(temp1!=null)
            root.next = temp1;

        if(temp2!=null)
            root.next = temp2;

        return dummy.next;
    }
}