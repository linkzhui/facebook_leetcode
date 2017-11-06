package Facebook.Valid_Binary_Search_Tree_98;

//BST的规则：
//Assume a BST is defined as follows:
//
//        The left subtree of a node contains only nodes with keys less than the node's key.
//        The right subtree of a node contains only nodes with keys greater than the node's key.
//        Both the left and right subtrees must also be binary search trees.

import Facebook.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    //iterative 解法：
    //use inorder traversal the tree

//    1) Create an empty stack S.
//    2) Initialize current node as root
//    3) Push the current node to S and set current = current->left until current is NULL
//    4) If current is NULL and stack is not empty then
//        a) Pop the top item from stack.
//        b) Print the popped item, set current = popped_item->right
//        c) Go to step 3.
//     5) If current is NULL and stack is empty then we are done.
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        if(root==null)
        {
            return true;
        }
        TreeNode cur = root;
        Integer prev = null;
        while(cur!=null||!stack.isEmpty())
        {
            if(cur!=null)
            {
                //if cur is not null, then we can keep find it's most smallest child
                stack.push(cur);
                cur= cur.left;
            }
            else{
                //if cur is null, we find current smallest node, the smallest node is on the top of the stack,
                cur = stack.pop();
                if(prev == null)
                {
                    //if it is the most smallest node, we set the prev equal to this node
                    prev = cur.val;
                }
                else if(prev<cur.val){
                    //if prev is not null, we check if the prev val is less than current node value
                    prev = cur.val;
                }
                else{
                    //otherwise we can return false
                    return false;
                }

                //we set cur node to it's right child to keep find next smallest node
                cur = cur.right;
            }
        }
        return true;
    }









    //recursive 解法：
    //set the left boundary and right bounday, then keep check current node exceed the boundary or not,
    // then update the boundary for this child and keep recursive for its child
    public boolean isValidBST_recursive(TreeNode root) {
        if(root==null)
        {
            return false;
        }
        return helper_recursive(root,Integer.MAX_VALUE,Integer.MIN_VALUE);

    }
    private boolean helper_recursive(TreeNode root, int max, int min)
    {
        if(root == null)
        {
            return true;
        }
        if(root.val<=max && root.val>=min)
        {
            return helper_recursive(root.left,min,root.val) && helper_recursive(root.right,root.val,max);
        }
        else{
            return false;
        }
    }
}
