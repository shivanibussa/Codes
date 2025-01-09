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
        {
            return null;
        }
        if(lists.length==1)
        {
            ListNode l = lists[0];
            return l;
        }
        ListNode totalLL = mergeTwoLists(lists[0],lists[1]);
        for(int i=2;i<lists.length;i++)
        {
            totalLL = mergeTwoLists(totalLL,lists[i]);
        }
        return totalLL;
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        ListNode temp = new ListNode(0);
        ListNode ll = temp;
        if(l1==null)
        {
            return l2;
        }
        if(l2==null)
        {
            return l1;
        }
        while(l1!=null && l2!=null)
        {
            if(l1.val<l2.val)
            {
                ll.next = l1;
                l1 = l1.next;
            }
            else
            {
                ll.next = l2;
                l2 = l2.next;
            }
            ll = ll.next;
        }
        if(l2!=null)
        {
            ll.next = l2;
        }
        if(l1!=null)
        {
            ll.next = l1;
        }
        return temp.next;
    }

}