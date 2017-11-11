package Facebook.Convert_BST_to_Circular_Double_LinkedList;

//Iterative Solution: Inorder Traversal the tree, the most smallest node in the tree is the root's most left child,
//therefore we keep find root's most left child, we need to store current node, therefore we use a stack to store the current node
//if current node is null, then we find current most smallest node, it is on the peek of the stack, then we pop this node from the stack,
// if this node have right child, we push right child into the stack, keep previous recursion


import Google.Tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public ListNode Iterative(TreeNode root){
        if(root==null)
        {
            return null;
        }
        ListNode dummy_head = null;
        ListNode cur_node = null;
        ListNode prev = dummy_head;
        TreeNode cur = root;
        Deque<TreeNode> stack = new LinkedList<>();
        while(cur!=null || !stack.isEmpty())
        {
            if(cur!=null)
            {
                stack.offerLast(cur);
                cur = cur.left;
            }
            else{
                //cur == null
                cur = stack.pollLast();

                cur_node = new ListNode(cur.val);
                cur_node.prev = prev;
                prev.next = cur_node;
                prev = cur_node;

                cur = cur.right;
            }
        }
        cur_node.next = dummy_head.next;
        dummy_head.next.prev = cur_node;
        return dummy_head.next;
    }



//    ListNode head = null;
//    ListNode prev = null;
//    ListNode cur = null;
//    boolean find_head = false;
//    public ListNode recursion(TreeNode root)
//    {
//        ListNode cur = new ListNode(root.val);
//    }
//
//    private void convert(TreeNode root){
//        if(root == null)
//        {
//            return;
//        }
//        convert(root.left);
//        cur = new ListNode(root.val);
//        if(!find_head)
//        {
//            head = cur;
//            prev = head;
//        }else{
//            cur.prev = prev;
//            prev.next = cur;
//            prev = cur;
//        }
//
//        convert(root.right);
//    }

    public class ListNode{
        ListNode prev;
        ListNode next;
        int val;
        public ListNode(int val)
        {
            this.val = val;
        }
    }

}
