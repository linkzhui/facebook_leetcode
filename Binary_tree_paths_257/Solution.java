package Facebook.Binary_tree_paths_257;

import Facebook.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//Solution 1: Iterate to traverse a tree
//same idea for bfs, but implemented with stack, we define a new treenode which contain current height and current node,
//initial state: we push root node into the stack,
// every time, the stack is not empty, we pop the peek from the stack, update the path according to its height (我们根据height来更新对应的arraylist的index位置的值), then generate its right child and left child, push back to stack.
//termination condition: if left child and right child is null, then we know we find a path

//
//and we use a arraylist to store current path, if we pop a node from the stack,

//solution 2: recursion to traverse a tree

//if node.left and node.right are both null, then we know we find a path
//the initial state is root node,
//then we expand root node to generate root.left child and root.right child
//we keep doing recursion to it's child node to find a path
// 2种 termination condition ->  1. if root.left and root.right are both null or 2. current node is null
//the recursion function will need three parameters, the current node, stringbuilder to store the current path and list to store the final result
//in the recursion function, we will add current node into the stringbuilder, when we return back to previous level, we will delete current node

//time complexity O(N) : each node will go through once
//space complexity O(N+N) -> O(N) : the N will be level of recursion method and we need a stringBuilder to store the path, the stringbuilder's length is N


public class Solution {

    //---------------------------------------iterator-----------------------------------------
    public List<String> binaryTreePaths_iterator(TreeNode root) {
        List<String> result = new ArrayList<>();
        if(root == null)
        {
            return result;
        }
        Deque<Node> stack = new ArrayDeque<>();
        stack.offerLast(new Node(root,0));
        List<Integer> path = new ArrayList<>();

        while(!stack.isEmpty())
        {
            Node temp = stack.pollLast();

            //update the path
            if(path.size() == temp.height)
            {
                path.add(temp.root.val);
            }
            else{
                path.set(temp.height,temp.root.val);
            }
            if(temp.root.left == null && temp.root.right == null)
            {
                String prefix="";
                StringBuilder sb = new StringBuilder();
                for(int i = 0;i<=temp.height;i++)
                {
                    sb.append(prefix+path.get(i));
                    prefix = "->";
                }
                result.add(sb.toString());
            }

            if(temp.root.right!=null)
            {
                stack.offerLast(new Node(temp.root.right,temp.height+1));
            }
            if(temp.root.left!=null)
            {
                stack.offerLast(new Node(temp.root.left,temp.height+1));
            }
        }
        return result;
    }

    private class Node{
        TreeNode root;
        int height;
        public Node(TreeNode root,int height)
        {
            this.root = root;
            this.height = height;
        }
    }


    //   ---------------------------------recursion-----------------------------------------

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        if(root == null)
        {
            return result;
        }

        helper(root,sb,result);
        return result;
    }
    private void helper(TreeNode root,StringBuilder sb, List<String> result)
    {
        if(root == null)
        {
            //current node is null
            return;
        }
        int length = sb.length();
        sb.append(root.val);
        if(root.left == null && root.right == null)
        {
            //the path is find
            result.add(sb.toString());
        }
        else{
            //still have right child or left child
            sb.append("->");
            helper(root.left,sb,result);
            helper(root.right,sb,result);
        }
        sb.setLength(length); //remove the current node
    }
}
