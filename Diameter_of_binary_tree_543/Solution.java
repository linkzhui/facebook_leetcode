package Facebook.Diameter_of_binary_tree_543;

import Facebook.TreeNode;


//For every node, length of longest path are:  MaxDepth of its left subtree + MaxDepth of its right subtree.

//to find the longest path in a tree, we can run get_height for every node in a tree
//the longest path for this node will be: left_child_height + right_child_height

//the we return max(left_height,right_height)+1 as max depth of current node

//time complex: if tree is completed tree, time will be (log(n)); otherwise the time will be the height of the deepest tree
//space complex: is same with time complexity
public class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] max= new int[1];
        helper(max,root);
        return max[0];
    }
    private int helper(int[] max, TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int left_height = helper(max,root.left);
        int right_height = helper(max,root.right);
        //diameter of current node is: MaxDepth of left subtree + MaxDepth of its right subtree.
        max[0] = Math.max(left_height+right_height,max[0]);

        //return max(left_height,right_height)+1 as max depth of current node
        return Math.max(left_height,right_height)+1;
    }
}
