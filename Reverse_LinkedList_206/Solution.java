package Facebook.Reverse_LinkedList_206;

import Google.LinkedList.ListNode;

public class Solution {

    public ListNode Iterative(ListNode node)
    {
        if(node == null)
        {
            return node;
        }
        ListNode prev = null;
        while(node!=null)
        {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }

    //recursive way
    public ListNode reverseList(ListNode head) {
        while(head==null||head.next==null)
        {
            return head;
        }
        ListNode prev = head;
        ListNode next = head.next;
        head=reverseList(next);
        next.next = prev;
        prev.next=null; //这里要注意，不然会变成double linked-list
        return head;
    }
}
