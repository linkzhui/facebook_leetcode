package Facebook.Binary_Search_Tree_Iterator_173;


import Facebook.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class BSTIterator {

    TreeNode root;
    Deque<TreeNode> stack;
    Integer next;
    public BSTIterator(TreeNode root) {
        this.root = root;
        stack = new ArrayDeque<>();
        while(root!=null)
        {
            //use while loop to find the most smallest node in the tree
            stack.offerLast(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(next!=null)
        {
            return true;
        }
        if(stack.isEmpty())
        {
            return false;
        }
        TreeNode temp = stack.pollLast();   //get current smallest value in the stack, then go through this node's right child's left child to find the next smallest value
        next = temp.val;
        temp = temp.right;
        while(temp!=null)
        {
            stack.offerLast(temp);
            temp=temp.left;
        }
        return true;
    }

    /** @return the next smallest number */
    public int next() {
        if(!hasNext())
        {
            //throw exception;
        }
        int temp = next;
        next = null;
        return temp;
    }
}