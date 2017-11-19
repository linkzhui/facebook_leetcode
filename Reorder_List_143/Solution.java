package Facebook.Reorder_List_143;


import Google.LinkedList.ListNode;


//找到中间点，根据中间点分为两个链表，reverse第二个链表，merge两个链表
//time complexity O(n）
//space complexity O(1)
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null
                || head.next == null
                || head.next.next == null)
            return;

        ListNode slow = head;
        ListNode fast = head;

        // 找到中间结点
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode second = slow.next;
        // 注意置空，分为两个链表
        // 第一个链表的长度大于（+1）等于第二个链表长度
        slow.next = null;
        // 反转后半链表
        second = reverse(second);

        // 合并两个链表
        // 把第二个链表插在第一个链表中

        while (second != null) {
            // 暂存第一个后续结点
            ListNode next = head.next;
            head.next = second;
            second = second.next;
            head.next.next = next;
            head = next;
        }
    }

    private ListNode reverse(ListNode head)
    {
        ListNode prev = null;
        ListNode next = null;
        while(head!=null)
        {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
