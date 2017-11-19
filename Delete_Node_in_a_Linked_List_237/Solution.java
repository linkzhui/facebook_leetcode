package Facebook.Delete_Node_in_a_Linked_List_237;

//the usually way for us to delete a node is pointer current node's previous to current node's next. since we only know this node, we don't know it is previous node
//then we can replace current node's value with current node's next value, then we pointer current node's next to its next next.
// node.next = node.next.next;

import Google.LinkedList.ListNode;

//then it is the same way for us to delete this node.
public class Solution {
    public void deleteNode(ListNode node) {
        node.value = node.next.value;
        node.next = node.next.next;
    }
}
