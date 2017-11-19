package Facebook.Binary_Search_Tree_Iterator_173;


import Facebook.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

//we will using inorder tree traversal to go through the tree.
//when we initial a iterator, we will find the smallest number of node first, and store this node to next(we need a variable to store next)
//the next method will return next,

// has next method,
// we will check if next is null, if it is null, we will check stack, if stack is null, we return false.
// if stack is not null, we pop the element from the stack, push this node's right child into stack, then keep looping to find next
// most smallest element in the stack.

//inorder tree traversal order:
//1) Create an empty stack S.
//2) Initialize current node as root
//3) Push the current node to S and set current = current->left until current is NULL
//4) If current is NULL and stack is not empty then
//a) Pop the top item from stack.
//b) Print the popped item, set current = popped_item->right
//c) Go to step 3.
//5) If current is NULL and stack is empty then we are done.
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