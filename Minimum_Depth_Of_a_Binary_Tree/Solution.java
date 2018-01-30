package Facebook.Minimum_Depth_Of_a_Binary_Tree;


//The idea is to traverse the given Binary Tree. For every node, check if it is a leaf node. If yes, then return 1.
//if current node have right child and left child, recursive both child node, return the minimum depth of two children + 1 (加1是因为要加上当前的level)
//if current node only have one child, then only recursive one children


import Google.Tree.TreeNode;

import java.util.Stack;

//
//走树，如果是leaf，return 0，然后当前节点没有左孩子同时没有右孩子的话，
public class Solution {
    int minDepth(TreeNode root)
    {
        //recursive way
        //check corner case, if root of the tree is null
        if(root == null)
        {
            return 0;
        }

        //base case: current node have no left or right children
        if(root.left == null && root.right == null)
        {
            //current node is leaf node
            return 1;
        }
        else if(root.left == null)
        {
            //if current node have no left child
            return minDepth(root.right);
        }
        else if(root.right == null)
        {
            //current node have no right child
            return minDepth(root.left);
        }
        else{
            //current node have both left node and right node
            return Math.min(minDepth(root.left),minDepth(root.right));
        }
    }

    //iterate way
    public int minDepth_2(TreeNode root) {
        if(root == null)
        {
            return 0;
        }
        int height = Integer.MAX_VALUE;
        Stack<MyTreeNode> stack = new Stack<>();
        stack.push(new MyTreeNode(root,1));
        while(!stack.isEmpty()){
            MyTreeNode node = stack.pop();
            if(node._root.left==null&node._root.right==null)
            {
                height = node._height<height? node._height:height;
            }
            if(node._root.right!=null)
            {
                stack.push(new MyTreeNode(node._root.right,node._height+1));
            }
            if(node._root.left!=null)
            {
                stack.push(new MyTreeNode(node._root.left,node._height+1));
            }
        }
        return height;
    }
    private class MyTreeNode{
        TreeNode _root;
        int _height;
        public MyTreeNode(TreeNode root, int height){
            _root = root;
            _height = height;
        }
    }
}
